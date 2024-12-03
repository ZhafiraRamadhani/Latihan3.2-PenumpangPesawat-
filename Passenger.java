// Kelas Passenger yang merepresentasikan seorang penumpang
class Passenger {
    String name; // Nama penumpang
    Passenger next; // Referensi ke penumpang berikutnya

    // Konstruktor untuk membuat objek Passenger
    public Passenger(String name) {
        this.name = name;
        this.next = null; // Awalnya, next diatur ke null
    }
}

// Kelas Flight yang merepresentasikan daftar penumpang
class Flight {
    private Passenger head; // Kepala dari linked list

    // Konstruktor untuk membuat objek Flight
    public Flight() {
        this.head = null; // Awalnya, head diatur ke null
    }

    // Metode untuk menambahkan penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger; // Jika daftar kosong, penumpang baru menjadi head
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next; // Mencari akhir dari linked list
            }
            current.next = newPassenger; // Menambahkan penumpang baru di akhir
        }
    }

    // Metode untuk menghapus penumpang dari daftar berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("No passengers to remove.");
            return;
        }

        // Jika penumpang yang ingin dihapus adalah head
        if (head.name.equals(name)) {
            head = head.next; // Mengatur head ke penumpang berikutnya
            System.out.println("Removed passenger: " + name);
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        // Mencari penumpang yang ingin dihapus
        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        // Jika penumpang ditemukan
        if (current != null) {
            previous.next = current.next; // Menghapus penumpang dari daftar
            System.out.println("Removed passenger: " + name);
        } else {
            System.out.println("Passenger not found: " + name);
        }
    }

    // Metode untuk menampilkan semua penumpang
    public void displayPassengers() {
        if (head == null) {
            System.out.println("No passengers in the flight.");
            return;
        }

        Passenger current = head;
        System.out.println("Passengers on the flight:");
        while (current != null) {
            System.out.println("- " + current.name); // Menampilkan nama penumpang
            current = current.next; // Melanjutkan ke penumpang berikutnya
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        Flight flight = new Flight(); // Membuat objek Flight

        // Menambahkan penumpang ke daftar
        flight.addPassenger("Zha");
        flight.addPassenger("Fira");
        flight.addPassenger("Zahra");

        // Menampilkan semua penumpang
        flight.displayPassengers();

        // Menghapus penumpang
        flight.removePassenger("Zahra");
        flight.displayPassengers();

        // Mencoba menghapus penumpang yang tidak ada
        flight.removePassenger("Laila");

        // Menampilkan semua penumpang setelah penghapusan
        flight.displayPassengers();
    }
}