## MoneyManager-Android
Aplikasi untuk mempermudah dalam pencatatan keuangan 
## Fitur
* SQLite – sebagai database untuk menyimpan data user dan data catatan pengeluaran
* Recycler View – menampilkan data dalam bentuk list, diterapkan pada halaman home
* Picasso – mengatur gambar yang bersumber dari url internet, diterapkan pada halaman about us
* SlideView – untuk membuat tampilan yang lebih interaktif, diterapkan pada halaman about us
* Grafik Pie – untuk mempermudah penyajian data keuangan user, diterapkan pada halaman grafik income dan grafik expenses
* Maps – diterapkan pada halaman about us 
* Kamera API–  untuk mempermudah user dalam mendokumentasikan sesuatu, diterapkan pada halaman tambah catatan
* Date Picker – untuk mempermudah user memilih tanggal, diterapkan pada halaman tambah catatan dan edit catatan.
* Splash Screen – untuk memberi tampilan ketika sedang proses loading membuka aplikasi agar lebih menarik

## Screenshot Aplikasi
### 1. Halaman Awal
Halaman ketika proses loading membuka aplikasi, menggunakan splash screen <br><br>
<img src="image/splashscreen.jpeg" width=240 height =430>

### 2. Login
Sebelum menggunakan aplikasi, user harus login terlebih dahulu dengan menginputkan email dan password yang telah terdaftar. Jika user belum memiliki akun, user harus mendaftar terlebih dahulu pada halaman register dengan klik tombol “Create Account” <br><br>
<img src="image/login.jpeg" width=240 height =430>

### 3. Register
Pada halaman ini user bisa membuat akun untuk masuk ke aplikasi, user harus menginputkan username, email, password dan konfirmasi password. Ketika ada kolom yang belum diisi, email tidak sesuai dengan format, atau kolom konfirmasi password tidak bernilai sama dengan password maka akan  muncul notifikasi. 
Jika user telah menginputkan data sesuai ketentuan klik tombol register, maka akun akan dibuat dan halaman akan otomatis kembali ke halaman login lagi
<img src="image/register.jpeg" width=240 height =430>

### 4. Home
Terdapat informasi berapa total pengeluaran, pemasukan, dan jumlah saldo user saat ini. Rincian catatan keuangan user disajikan dalam bentu recycler view <br><br>
<img src="image/home.jpeg" width=240 height =430>

### 5. Tambah Catatan
Pada halaman home, tekan button tambah maka akan muncul tampilan halaman tambah catatan. Untuk mencatat pemasukan klik Income, jika ingin mencatat pengeluaran klik Expenses. Masukkan tanggal dengan menekan icon kalender, pilih kategori yang disediakan, masukkan nominal, lalu masukkan catatan, anda juga dapat menambahkan dokumentasi berupa foto pada catatan anda, lalu klik tombol simpan, maka anda akan otomatis kembali ke halaman home dan catatan yang baru saja anda masukkan akan otomatis tampil pada recycle view <br><br>
<img src="image/income.jpeg" width=240 height =430> <img src="image/expenses.jpeg" width=240 height =430>

### 6. Detail Catatan
User dapat melihat catatan keuangan yang telah dibuat yaitu pada halaman home klik catatan yang ingin di lihat pada list recycle view <br><br>
<img src="image/detail.jpeg" width=240 height =430>

### 7. Edit Catatan
User juga dapat mengedit catatan yang sudah terlanjur dibuat, dengan klik catatan yang akan diedit, dan pilih tombol edit, lalu anda akan masuk ke halaman edit catatan, di halaman edit catatan ini anda bisa mengoreksi tanggal, category, nominal dan catatan tentang keuangan anda, lalu jika sudah benar, klik tombol update, maka otomatis catatan, termasuk hasil income/expenses yg dimasukkan akan otomatis berubah <br><br>
<img src="image/edit.jpeg" width=240 height =430>

### 8. Hapus Catatan
Jika ada catatan yang ingin dihapus, user dapat menghapus catatan dengan klik catatan yang akan dihapus, dan pilih tombol hapus, lalu anda akan ada dialog alert untuk mengonfirmasi apakah user yakin untuk menghapus jika anda yakin ingin menghapus, langsung tekan tombol yes, maka otomatis catatan, termasuk hasil income/outcome yg dimasukkan akan otomatis terhapus  <br><br>
<img src="image/delete.jpeg" width=240 height =430>

### 9. Grafik Income
User dapat melihat grafik pemasukkan yang dia dapatkan yaitu pada halaman home pilihlah menu sidebar dan klik menu “grafik income” lalu anda akan masuk ke halaman grafik income, yang berisi grafik pie tentang pemasukan yang dilakukan dibandingkan berdasarkan kategory income <br><br>
<img src="image/menu.jpeg" width=240 height =430> <img src="image/grafikIncome.jpeg" width=240 height =430>

### 10. Grafik Expenses
User juga dapat melihat grafik pengeluaran yang dia lakukan yaitu pada menu sidebar klik menu “grafik expenses” lalu anda akan masuk ke halaman grafik expenses, yang berisi grafik pie tentang pengeluaran yang dilakukan dibandingkan berdasarkan kategory expenses <br><br>
<img src="image/grafikEx.jpeg" width=240 height =430>

### 11. About Us
Halaman about us berisi informasi untuk mengetahui siapa saja yang berkontribusi dalam pembuatan aplikasi ini, juga berisi lokasi tempat dibuatnya aplikasi ini untuk membuka halaman ini yaitu pada halaman home pilihlah menu sidebar dan klik menu “about us” lalu anda akan masuk ke halaman about us, di halaman about us ini menggunakan slide view dan juga tersedia fitur maps, untuk mengetahui lokasi pembuatan aplikasi dengan klik tombol “find us” <br><br>
<img src="image/profilFer.jpeg" width=240 height =430> <img src="image/profilMal.jpeg" width=240 height =430><img src="image/polinema.jpeg" width=240 height =430>

### 12. Maps
Maps polinema <br><br>
<img src="image/maps.jpeg" width=240 height =430>

### 13. Logout Account
Terakhir, user dapat keluar dari akunnya dengan klik tombol “log out” pada menu sidebar











