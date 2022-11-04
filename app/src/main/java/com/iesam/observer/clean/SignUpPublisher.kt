package com.iesam.observer.clean

import com.iesam.observer.User
import com.iesam.observer.clean.subscriber.Subscriber

class SignUpPublisher {

    private val subscribers: MutableList<Subscriber> = mutableListOf() //Vacío

    fun signUpUser(user: User) {
        //Dar de alta en base de datos.
        //Si ha ido bien, entonces:
        signUpCompleted()
    }

    private fun signUpCompleted() {
        subscribers.forEach { subscriber ->
            subscriber.updated()
        }
    }

    fun addSubscriber(subsriber: Subscriber) {
        subscribers.add(subsriber)
    }

    fun removeSubscriber(subsriber: Subscriber) {
        subscribers.remove(subsriber)
    }


}