public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static void main(String[] args) {
//    testShowTodoList();
//    testAddTodoList();
        testRemoveTodoList();
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

    //View Show Todo List
    public  static void viewShowTodoList(){

    }

    //View Add Todo List
    public static void  viewAddTodoList(){

    }

    //View Remove Todo List
    public static void viewRemoveTodoList(){

    }
}