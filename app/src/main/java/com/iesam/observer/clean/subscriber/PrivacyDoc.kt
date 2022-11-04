package com.iesam.observer.clean.subscriber

class PrivacyDoc : Subscriber {


    fun sendDoc() {
        //Código para crear y enviar la doc de privacidad
    }

    override fun updated() {
        sendDoc()
    }

}