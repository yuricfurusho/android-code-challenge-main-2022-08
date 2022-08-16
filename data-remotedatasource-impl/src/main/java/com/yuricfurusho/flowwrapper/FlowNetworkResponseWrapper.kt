package com.yuricfurusho.flowwrapper

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class FlowNetworkResponseWrapper @Inject constructor(
) {
    /**
     * Wrapper function for network call responses
     *
     * @param coroutineDispatcher It is recommended to use `IO.Dispatcher` for Production and `TestCoroutineDispatcher` for Testing
     * @param apiCall The suspend function network call that returns T
     *
     * @returns a flow with 2 Result emissions
     * - First emission is a `Loading` state.
     * - Second emission is a `Ready` State, an `Error` State or a `NetworkError` State.
     * Second emission is accompanied by corresponding data.
     *
     * It is recommended wrapping every network call because every network call is subject to these states.
     * The choice of when and how to represent each state belongs to upper layers/classes.
     */
    fun <T> wrap(
        coroutineDispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): Flow<Result<T>> = flow {
        emit(Result.Loading)
        emit(Result.Success(apiCall.invoke()))
    }.catch { throwable ->
        when (throwable) {
            is HttpException -> {
                emit(
                    Result.Error(
                        throwable.code(),
                        throwable.message()
                    )
                )

            }
            else -> {
                emit(
                    Result.NetworkError
                )
            }
        }
    }.flowOn(coroutineDispatcher)
}
