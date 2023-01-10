package id.esaku.rentsport

import android.content.Context
import android.content.SharedPreferences

class Preferences {

    var APP_NAME = R.string.app_name

    private var log_status = "log_status"
    private var token_type = "token_type"
    private var kelas = "kelas"
    private var idDevice = "id_device"
    private var email = "email"
    private var namaSekolah = "nama_sekolah"
    private var nama = "nama"
    private var nis = "kelas"
    private var expires = "expires"
    private var token = "token"
    private var noHp = "no_hp"
    private var kodePP = "kodepp"
    private var saveData = "save_data"
    private var password = "password"
    private var fingerprint = "fingerprint"
    private var kodeRumah = "koderumah"
    private var darkMode = "darkMode"

    var sp: SharedPreferences? = null
    var spEditor: SharedPreferences.Editor? = null

    fun setPreferences(context: Context) {
        sp = context.getSharedPreferences(APP_NAME.toString(), Context.MODE_PRIVATE)
        spEditor = sp?.edit()
    }

    fun preferencesLogout() {
        spEditor!!.clear()
        spEditor!!.commit()
    }


    fun saveFingerprintState(value: Boolean) {
        spEditor!!.putBoolean(fingerprint, value)
        spEditor!!.commit()
    }

    fun saveDarkMode(value: Boolean) {
        spEditor!!.putBoolean(darkMode, value)
        spEditor!!.commit()
    }

    fun saveLogStatus(value: Boolean) {
        spEditor!!.putBoolean(log_status, value)
        spEditor!!.commit()
    }

    fun saveSaveData(value: Boolean) {
        spEditor!!.putBoolean(saveData, value)
        spEditor!!.commit()
    }

    fun saveToken(value: String?) {
        spEditor!!.putString(token, value)
        spEditor!!.commit()
    }

    fun saveIdDevice(value: Int) {
        spEditor!!.putInt(idDevice, value)
        spEditor!!.commit()
    }



    fun saveNama(value: String?) {
        spEditor!!.putString(nama, value)
        spEditor!!.commit()
    }

    fun saveKelas(value: String?) {
        spEditor!!.putString(kelas, value)
        spEditor!!.commit()
    }

    fun saveTokenType(value: String?) {
        spEditor!!.putString(token_type, value)
        spEditor!!.commit()
    }

    fun saveExpires(value: String?) {
        spEditor!!.putString(expires, value)
        spEditor!!.commit()
    }

    fun saveNoHp(value: String?) {
        spEditor!!.putString(noHp, value)
        spEditor!!.commit()
    }

    fun saveNIS(value: String?) {
        spEditor!!.putString(nis, value)
        spEditor!!.commit()
    }

    fun saveEmail(value: String?) {
        spEditor!!.putString(email, value)
        spEditor!!.commit()
    }

    fun savePassword(value: String?) {
        spEditor!!.putString(password, value)
        spEditor!!.commit()
    }

    fun saveKodePP(value: String?) {
        spEditor!!.putString(kodePP, value)
        spEditor!!.commit()
    }

    fun saveNamaSekolah(value: String?) {
        spEditor!!.putString(namaSekolah, value)
        spEditor!!.commit()
    }

    fun saveKodeRumah(value: String?) {
        spEditor!!.putString(kodeRumah, value)
        spEditor!!.commit()
    }

    fun getLogStatus(): Boolean {
        return sp!!.getBoolean(log_status, false)
    }

    fun getFingerprintState(): Boolean {
        return sp!!.getBoolean(fingerprint, false)
    }

    fun getDarkMode(): Boolean {
        return sp!!.getBoolean(darkMode, false)
    }

    fun getSaveData(): Boolean {
        return sp!!.getBoolean(saveData, false)
    }

    fun getExpires(): String? {
        return sp!!.getString(expires, "N/A")
    }

    fun getNama(): String? {
        return sp!!.getString(nama, "N/A")
    }

    fun getIdDevice(): Int {
        return sp!!.getInt(idDevice, 0)
    }

    fun getPassword(): String? {
        return sp!!.getString(password, "N/A")
    }

    fun getEmail(): String? {
        return sp!!.getString(email, "N/A")
    }

    fun getNamaSekolah(): String? {
        return sp!!.getString(namaSekolah, "N/A")
    }

    fun getNIS(): String? {
        return sp!!.getString(nis, "N/A")
    }

    fun getTokenType(): String? {
        return sp!!.getString(token_type, "N/A")
    }



    fun getKelas(): String? {
        return sp!!.getString(kelas, "N/A")
    }

    fun getToken(): String? {
        return sp!!.getString(token, "N/A")
    }

    fun getNoHp(): String? {
        return sp!!.getString(noHp, "N/A")
    }

    fun getKodePP(): String? {
        return sp!!.getString(kodePP, "N/A")
    }

    fun getKodeRumah(): String? {
        return sp!!.getString(kodeRumah, "N/A")
    }
}