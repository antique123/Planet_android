package com.sesac.planet.domain.usecase

class RequestEmailCertificationCodeUseCase {
    suspend operator fun invoke(email: String): Boolean {
        return true
    }
}