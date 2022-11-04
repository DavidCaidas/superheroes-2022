package com.iesam.observer

class SignUp {

    fun signUpUser(user: User){
        //Dar de alta en base de datos.
        //Si ha ido bien, entonces:
        signUpCompleted()
    }

    private fun signUpCompleted(){
        sendWelcomeEmail()
        signUpCyL()
        sendPushNotification()
        sendPrivacyDoc()
        signUpSpain()
    }

    private fun sendWelcomeEmail(){
        //Código para enviar un email
    }

    private fun signUpCyL(){
        //Código para dar de alta en el sistema de CyL
    }

    private fun sendPushNotification(){
        //Código para enviar una pushNotification
    }

    private fun sendPrivacyDoc(){
        //Código para crear y enviar documento de privacidad
    }

    private fun signUpSpain(){

    }
}