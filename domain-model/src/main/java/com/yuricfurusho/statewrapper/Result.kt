package com.yuricfurusho.statewrapper

/**
 * A generic class that holds a value or error.
 * @param <T>
 */

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val code: Int, val errorMessage: String) : Result<Nothing>()

    object NetworkError : Result<Nothing>()
    object Loading : Result<Nothing>()
    object Inactive : Result<Nothing>()


    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$errorMessage]"
            is NetworkError -> "Network Error"
            Loading -> "Loading"
            Inactive -> "Inactive"
        }
    }

    fun <T> mapSuccessData(transform: (R) -> T): Result<T> =
        when (this) {
            is Success -> Success(transform(this.data))
            is Error -> Error(this.code, this.errorMessage)
            Inactive -> Inactive
            Loading -> Loading
            is NetworkError -> NetworkError
        }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null