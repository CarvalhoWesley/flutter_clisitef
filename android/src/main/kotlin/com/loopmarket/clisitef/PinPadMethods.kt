package com.loopmarket.clisitef

import android.annotation.SuppressLint
import android.util.Log
import br.com.softwareexpress.sitef.android.CliSiTef

class PinPadMethods(cliSiTef: CliSiTef): SiTefClient(cliSiTef) {
    fun setDisplayMessage(message: String) {
        success(cliSiTef.pinpad.setDisplayMessage(message))
    }

    fun readYesOrNo(message: String) {
        success(cliSiTef.pinpad.readYesNo(message))
    }

    @SuppressLint("LongLogTag")
    fun isPresent() {
        Thread {
            try {
                val result = cliSiTef.pinpad.isPresent // Executa na thread separada
                success(result) // Chama o callback com o resultado
            } catch (e: Exception) {
                success(false) // Em caso de exceção, retorna `false`
            } catch (e: Error) {
                Log.e("PinPadMethods::isPresent", e.toString())
                success(false)
            }
        }.start()
    }
}