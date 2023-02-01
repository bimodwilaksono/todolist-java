public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
//    testShowTodoList();
//    testAddTodoList();
//        testRemoveTodoList();
//        testInput();
//        testViewShowTodoList();
//    testViewAddTodoList();
//        testViewRemoveTodoList();
    viewShowTodoList();
    }

    //Show Todo List
    public static void showTodoList(){
        for(var i = 0; i< model.length; i++){
          var todo = model[i];
          var nomor = i + 1;

          if (todo != null){
              System.out.println(nomor + ". " + todo);
          }
        }
    }
    //Tes Show Todo List
    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Todo List";
        showTodoList();
    }


    // Add Todo List
    public  static void addTodoList(String todo){

        var isFull= true;
        for (var i = 0; i< model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        //Jika Penuh tambah ukuran array
        if (isFull){
            var temp = model;
            model = new String[model.length*2];
            for (int i = 0; i < temp.length; i++) {
                model[i]= temp[i];
            }
        }


        for (var i = 0; i< model.length; i++){
            if (model[i]== null){
            model[i] = todo;
            break;
        }
    }
    }


    public static  void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Test" + i);
        }
        showTodoList();
    }

    // Remove Todo List
    public static boolean removeTodoList(Integer number){
        if (number - 1 >= model.length){
            return false;
        }

        if (model[number-1] == null){
            return false;
        } else {
            for (int i = number-1; i < model.length ; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        for (int i = 0; i < 4; i++) {
            addTodoList("Test" + i);
        }
        var result = removeTodoList(1);
        System.out.println(result);
        showTodoList();
    }

    //Input Data
    public static String input(String info){
        System.out.println(info);
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println(name);
    }

    //View Show Todo List
    public  static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Menu yang dipilih tidak ada");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        addTodoList("enam");
        viewShowTodoList();
    }

    //View Add Todo List
    public static void  viewAddTodoList(){
        System.out.printf("Menambah Todo List");
        var todo = input("Todo : (x batal)");

        if (todo.equals("x")){
            //
        } else {
            addTodoList(todo);
        }
    }

    public static void  testViewAddTodoList(){
        viewAddTodoList();

        showTodoList();
    }

    //View Remove Todo List
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus Todo List");
        var nomorTodo = input("No Todo List: (x batal)");

        if (nomorTodo.equals("x")){
            //
        } else {
           boolean success = removeTodoList(Integer.valueOf(nomorTodo));
           if (!success){
               System.out.println("Gagal Menghapus todolist : " + nomorTodo);
           }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewRemoveTodoList();
        showTodoList();
    }
}
