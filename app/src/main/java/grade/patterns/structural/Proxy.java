package grade.patterns.structural;

/**
 * Когда: нужен заместитель для контроля доступа, кеширования, логирования.
 * Пример: банкомат — прокси к банковскому аккаунту.
 * Заместитель выступает посредником между клиентом и реальным объектом, управляя доступом к нему.
 * Подходит ля ленивой загрузки, авторизации, логирования, кэширования или ограничения доступа.
 */
public class Proxy {

    interface File {
        void readFile();
    }

    static class MyFile implements File {

        @Override
        public void readFile() {
            System.out.println("My file");
        }
    }

    static class ProxyMyFile implements File {
        private MyFile myFile;

        public ProxyMyFile(MyFile myFile) {
            this.myFile = myFile;
        }

        @Override
        public void readFile() {
            if(true) {
                System.out.println("Access allowed!");
                myFile.readFile();
            }
        }
    }

    public static void main(String[] args) {
        ProxyMyFile proxyMyFile = new ProxyMyFile(new MyFile());
        proxyMyFile.readFile();
    }
}
