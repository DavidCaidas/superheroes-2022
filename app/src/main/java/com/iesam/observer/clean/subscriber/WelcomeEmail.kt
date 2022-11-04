package com.iesam.observer.clean.subscriber

class WelcomeEmail : Subscriber {


    fun sendEmail(){
        //Código para enviar un email
    }

    override fun updated() {
        sendEmail()
    }

}