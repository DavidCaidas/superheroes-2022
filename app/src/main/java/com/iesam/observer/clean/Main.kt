package com.iesam.observer.clean

import com.iesam.observer.User
import com.iesam.observer.clean.subscriber.PushNotification
import com.iesam.observer.clean.subscriber.SignUpSpain
import com.iesam.observer.clean.subscriber.WelcomeEmail

class Main {

    companion object {

        fun main() {

            //Sólo necesito en este momento enviar email de bienvenida y la push
            val welcomeEmail = WelcomeEmail()
            val pushNotification = PushNotification()
            val signUpSpain = SignUpSpain()

            //Objeto para dar de alta
            val signUpPublisher = SignUpPublisher()

            //Añado los subscriber interesados en el alta
            signUpPublisher.addSubscriber(welcomeEmail)
            signUpPublisher.addSubscriber(pushNotification)
            signUpPublisher.addSubscriber(signUpSpain)

            signUpPublisher.removeSubscriber(signUpSpain)

            //Recojo los datos del usuario y doy de alta
            signUpPublisher.signUpUser(User())

        }
    }
}