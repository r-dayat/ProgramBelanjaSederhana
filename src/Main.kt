import java.util.*


var keranjangBelanja: MutableList<String> = ArrayList()
val daftarBarang = arrayOf("Monitor", "Keyboard", "Mouse", "Speaker")
var saldo = 0
var saldoTambahan = 0
val reader = Scanner(System.`in`)

fun main(args: Array<String>){
    println("Masukkan jumlah saldo kamu : ")
    saldo = reader.nextInt()
    println("List barang yang tersedia :")
    listBarang()
    println("Saldo kamu adalah $saldo")
    println("Silahkan pilih barang yang tersedia :")
    do {
        pilihBarang()
        println("Tambah barang lagi ? Y / N")
        val tanya = readLine()
    } while (tanya != "N")
    bayar(hitungBelanja())

}

fun listBarang() {
    var harga = ""
    for (item in daftarBarang){
        when(item){
            "Monitor" -> harga = "10000"
            "Keyboard" -> harga = "2500"
            "Mouse" -> harga = "1000"
            "Speaker" -> harga = "3000"
        }
        println("$item -> Rp $harga")
    }
}

fun pilihBarang() {
    println("Masukkan nama barangnya : ")
    val namabarang = readLine()
    if(namabarang in daftarBarang){
        keranjangBelanja.add(namabarang!!)
    }
    else{
        println("Nama barang yang dimasukkan tidak ada atau kamu salah ketik nama barangnya")
        pilihBarang()
    }

}

fun hitungBelanja():Int{
    var totalBelanja = 0
    for(item in keranjangBelanja){
        totalBelanja += when(item){
            "Monitor" -> 10000
            "Keyboard" -> 2500
            "Mouse" -> 1000
            "Speaker" -> 3000
            else -> 0
        }
    }
    return totalBelanja
}

fun bayar(totalBelanja: Int){
    val jumlahUang = saldo
    if(jumlahUang > totalBelanja){
        saldo -= totalBelanja
        println("Barang yang kamu beli adalah ${keranjangBelanja.toList()}")
        println("Barang berhasil dibeli")
        println("Total belanja kamu adalah Rp $totalBelanja")
        println("Sisa saldo kamu adalah $saldo")
    }
    else{
        val uangKurang = totalBelanja - jumlahUang
        println("Saldo kamu tidak cukup, Saldo kamu kurang Rp $uangKurang")
        println("Mau tambah saldo kamu ? Y / N")
        val tanya = readLine()
        if(tanya == "Y"){
            tambahSaldo()
        }
        else{
            println("Barang gagal dibeli")
        }
    }
}

fun tambahSaldo(){
    println("Berapa tambah saldo berapa ? ")
    saldoTambahan = reader.nextInt()
    saldo += saldoTambahan
    bayar(hitungBelanja())
}


