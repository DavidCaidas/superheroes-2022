package com.iesam.observer.clean.subscriber

class PushNotification : Subscriber {


    fun sendPush() {
        //Código para enviar una notificación en la app
    }

    override fun updated() {
        sendPush()
    }

}