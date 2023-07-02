package controller;
import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    /////////////////////////////////////////main needs/////////////////////////////////////////
    @FXML private Button addcollage;
    @FXML private Button addlesson;
    @FXML private Button addprofessor;
    @FXML private Button addstudent;
    @FXML private Button btnCollage;
    @FXML private Button btnLesson;
    @FXML private Button btnProfessor;
    @FXML private Label btnStatus;
    @FXML private Button btnStudent;
    @FXML private AnchorPane archor;
    @FXML private Pane pnlStatus;
    @FXML private Button btnExit;
    @FXML private GridPane GPcollage;
    @FXML private GridPane GPlesson;
    @FXML private GridPane GPprofessor;
    @FXML private GridPane GPstudent;

/////////////////////////////////////////professor needs/////////////////////////////////////////
    ArrayList<professor> professors_arr = new ArrayList<>();
    ArrayList<Integer> deleteArr_p = new ArrayList<>();
    int id_p=1;
    @FXML private AnchorPane archor_add_p;
    @FXML private TextField search_p;
    @FXML private TextField lastname_p;
    @FXML private TextField name_p;
    @FXML private TextField numterm_p;
    @FXML private TextField status_p;
    @FXML private Text error_p;
    @FXML private TableView<professor> professor_table;
    @FXML private TableColumn<professor, Integer> Pid;
    @FXML private TableColumn<professor, Void> Pdel;
    @FXML private TableColumn<professor, Void> Pgrade;
    @FXML private TableColumn<professor, String> Plastname;
    @FXML private TableColumn<professor, Void> Plesson;
    @FXML private TableColumn<professor, String> Pname;
    @FXML private TableColumn<professor, Integer> Pnumterm;
    @FXML private TableColumn<professor, String> Pstatus;

/////////////////////////////////////////lessons needs/////////////////////////////////////////
    ArrayList<lesson> lessons_arr = new ArrayList<>();
    ArrayList<Integer> deleteArr_l = new ArrayList<>();
    int id_l=1;
    @FXML private AnchorPane archor_add_l;
    @FXML private TextField search_l;
    @FXML private TextField name_l;
    @FXML private TextField lessonUnit_l;
    @FXML private Text error_l;
    @FXML private TableView<lesson> lesson_table;
    @FXML private TableColumn<lesson, Integer> Lid;
    @FXML private TableColumn<lesson, String> Lname;
    @FXML private TableColumn<lesson, Integer> Llessonunit;
    @FXML private TableColumn<lesson, Void> Lcollage;
    @FXML private TableColumn<lesson, Void> Lprofessor;
    @FXML private TableColumn<lesson, Void> Ldel;

/////////////////////////////////////////student needs/////////////////////////////////////////
    ArrayList<student> students_arr = new ArrayList<>();
    ArrayList<Integer> deleteArr_s = new ArrayList<>();
    int id_s=1;
    @FXML private AnchorPane archor_add_s;
    @FXML private TextField search_s;
    @FXML private TextField name_s;
    @FXML private TextField lastname_s;
    @FXML private ChoiceBox collage_s;
    @FXML private Text error_s;
    @FXML private TableView<student> student_table;
    @FXML private TableColumn<student, Integer> Sid;
    @FXML private TableColumn<student, String> Sname;
    @FXML private TableColumn<student, Void> Slesson;
    @FXML private TableColumn<student, Integer> Slastname;
    @FXML private TableColumn<student, Void> Sdel;
    @FXML private TableColumn<student, Void> Sevaluation;
    @FXML private Label lessonUnit_text;
    @FXML private CheckBox lab;

/////////////////////////////////////////collage needs/////////////////////////////////////////
    ArrayList<collage> collages_arr = new ArrayList<>();
    ArrayList<Integer> deleteArr_c = new ArrayList<>();
    int id_c=1;
    @FXML private AnchorPane archor_add_c;
    @FXML private TextField search_c;
    @FXML private TextField name_c;
    @FXML private Text error_c;
    @FXML private TableView<collage> collage_table;
    @FXML private TableColumn<collage, Integer> Cid;
    @FXML private TableColumn<collage, String> Cname;
    @FXML private TableColumn<collage, Void> Cprofessor;
    @FXML private TableColumn<collage, Void> Clesson;
    @FXML private TableColumn<collage, Void> Cstudent;
    @FXML private TableColumn<collage, Void> Cdetail;
    @FXML private TableColumn<collage, Void> Cdel;

/////////////////////////////////////////list needs/////////////////////////////////////////
    @FXML private ChoiceBox<String> list_choice;
    @FXML private ChoiceBox<String> list_professor;
    @FXML private ListView<String> list_show;
    @FXML private AnchorPane archor_list;
    @FXML private Button list_add;
    int row_index = 0;
    String row_type = "";
    String row_ok = "";
/////////////////////////////////////////evaluation needs/////////////////////////////////////////
    @FXML private AnchorPane archor_evo;
    @FXML private Slider slider_1;
    @FXML private Slider slider_2;
    @FXML private Slider slider_3;
    @FXML private Slider slider_4;
    @FXML private Slider slider_5;
    @FXML private ChoiceBox<String> lesson_evo;
    @FXML private Label professor_evo;
    @FXML private Button save_evo;
    @FXML private AnchorPane archor_evo_p;
    @FXML private Text av_1;
    @FXML private Text av_2;
    @FXML private Text av_3;
    @FXML private Text av_4;
    @FXML private Text av_5;
    @FXML private Text av_t;



    @FXML private Text avc_1;
    @FXML private Text avc_2;
    @FXML private Text avc_3;
    @FXML private Text avc_4;
    @FXML private Text avc_5;
    @FXML private Text avc_t;
    @FXML private Text best_professor;
    @FXML private Text count_professor;
    @FXML private AnchorPane archor_evo_c;



    //for run tables
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        archor.getChildren().removeAll(archor_add_p,archor_add_l,archor_add_s,archor_add_c,archor_list,archor_evo,archor_evo_p,archor_evo_c);
        archor_list.getChildren().remove(list_professor);



        Pid.setCellValueFactory(new PropertyValueFactory<professor, Integer>("ID"));
        Pname.setCellValueFactory(new PropertyValueFactory<professor, String>("Name"));
        Plastname.setCellValueFactory(new PropertyValueFactory<professor, String>("LastName"));
        Pnumterm.setCellValueFactory(new PropertyValueFactory<professor, Integer>("NumTerm"));
        Pstatus.setCellValueFactory(new PropertyValueFactory<professor, String >("Status"));


        Lid.setCellValueFactory(new PropertyValueFactory<lesson, Integer>("ID"));
        Lname.setCellValueFactory(new PropertyValueFactory<lesson, String>("Name"));
        Llessonunit.setCellValueFactory(new PropertyValueFactory<lesson, Integer>("LessonUnit"));


        Sid.setCellValueFactory(new PropertyValueFactory<student, Integer>("ID"));
        Sname.setCellValueFactory(new PropertyValueFactory<student, String>("Name"));
        Slastname.setCellValueFactory(new PropertyValueFactory<student, Integer>("LastName"));


        Cid.setCellValueFactory(new PropertyValueFactory<collage, Integer>("ID"));
        Cname.setCellValueFactory(new PropertyValueFactory<collage, String>("Name"));
    }
    //for left side buttons
    @FXML private void handleClicks(ActionEvent event){
        handleClose1(event);
        if (event.getSource()==btnProfessor){
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(113,86,221), CornerRadii.EMPTY, Insets.EMPTY)));
            btnStatus.setText("PROFESSOR");
            GPprofessor.toFront();
        } else if (event.getSource()==btnStudent) {
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,63,99), CornerRadii.EMPTY, Insets.EMPTY)));
            btnStatus.setText("STUDENT");
            GPstudent.toFront();
        } else if (event.getSource()==btnLesson) {
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));
            btnStatus.setText("LESSON");
            GPlesson.toFront();
        } else if (event.getSource()==btnCollage) {
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(42,28,66), CornerRadii.EMPTY, Insets.EMPTY)));
            btnStatus.setText("COLLAGE");
            GPcollage.toFront();
        }
    }
    //to close GOLESTAN
    @FXML void handleClose(ActionEvent event) {
        if (event.getSource()==btnExit){
            System.exit(0);
        }
    }
    //for open page form p,s,l,c
    @FXML void handleAdd(ActionEvent event) {
        handleClose1(event);
        if (event.getSource()==addprofessor){
            archor.getChildren().add(archor_add_p);
        } else if (event.getSource()==addstudent) {
            collage_s.getItems().clear();
            for (int i=0;i<collages_arr.size();i++){
                collage_s.getItems().add(collages_arr.get(i).getName());
            }
            archor.getChildren().add(archor_add_s);
        } else if (event.getSource()==addlesson) {
            archor.getChildren().add(archor_add_l);
        } else if (event.getSource()==addcollage) {
            archor.getChildren().add(archor_add_c);
        }
    }
    //for close all opened windows in app
    @FXML void handleClose1(ActionEvent event) {
        archor.getChildren().removeAll(archor_add_p,archor_add_l,archor_add_s,archor_add_c,archor_list,archor_evo,archor_evo_p,archor_evo_c);
        archor_list.getChildren().remove(list_professor);
    }
    //this is a method for add and controll list windowses
    @FXML void add_list(ActionEvent event) {
        String name = list_choice.getValue();
        if (name != null) {
            if (row_ok.equals("collage")){
                if (row_type.equals("lesson")) {
                    if (list_show.getItems().size() == 0) {
                        collages_arr.get(row_index).setLesson(name);
                    } else {
                        for (int i = 0; i < list_show.getItems().size(); i++) {
                            if (name.equals(list_show.getItems().get(i))) {
                                break;
                            } else if (i == list_show.getItems().size() - 1) {
                                collages_arr.get(row_index).setLesson(name);
                            }
                        }
                    }
                    list_show.getItems().clear();
                    list_show.getItems().addAll(collages_arr.get(row_index).getLesson());
                } else if (row_type.equals("professor")) {
                    if (list_show.getItems().size() == 0) {
                        collages_arr.get(row_index).setProfessor(name);
                    } else {
                        for (int i = 0; i < list_show.getItems().size(); i++) {
                            if (name.equals(list_show.getItems().get(i))) {
                                break;
                            } else if (i == list_show.getItems().size() - 1) {
                                collages_arr.get(row_index).setProfessor(name);
                            }
                        }
                    }
                    list_show.getItems().clear();
                    list_show.getItems().addAll(collages_arr.get(row_index).getProfessor());
                } else if (row_type.equals("student")) {
                    if (list_show.getItems().size() == 0) {
                        collages_arr.get(row_index).setStudent(name);
                    } else {
                        for (int i = 0; i < list_show.getItems().size(); i++) {
                            if (name.equals(list_show.getItems().get(i))) {
                                break;
                            } else if (i == list_show.getItems().size() - 1) {
                                collages_arr.get(row_index).setStudent(name);
                            }
                        }
                    }
                    list_show.getItems().clear();
                    list_show.getItems().addAll(collages_arr.get(row_index).getStudent());
                }
            }
            if (row_ok.equals("professor")){
                if (row_type.equals("lesson")) {
                    if (list_show.getItems().size() == 0) {
                        professors_arr.get(row_index).setLesson(name);
                    } else {
                        for (int i = 0; i < list_show.getItems().size(); i++) {
                            if (name.equals(list_show.getItems().get(i))) {
                                break;
                            } else if (i == list_show.getItems().size() - 1) {
                                professors_arr.get(row_index).setLesson(name);
                            }
                        }
                    }
                    list_show.getItems().clear();
                    list_show.getItems().addAll(professors_arr.get(row_index).getLesson());
                }
            }
            if (row_ok.equals("student")){
                String prof = list_professor.getValue();
                if (prof!=null){
                    if (row_type.equals("lesson")) {
                        if (list_show.getItems().size() == 0) {
                            students_arr.get(row_index).setLesson(name);
                            students_arr.get(row_index).setProfessor(prof);
                        } else {
                            for (int i = 0; i < list_show.getItems().size(); i++) {
                                String [] s = list_show.getItems().get(i).split(" => ");
                                if (name.equals(s[0])) {
                                    break;
                                } else if (i == list_show.getItems().size() - 1) {
                                    students_arr.get(row_index).setLesson(name);
                                    students_arr.get(row_index).setProfessor(prof);
                                }
                            }
                        }

                        ArrayList<String> str = new ArrayList<>();
                        for (int i=0;i<students_arr.get(row_index).getLesson().size();i++){
                            str.add(students_arr.get(row_index).getLesson().get(i)+" => "+students_arr.get(row_index).getProfessor().get(i));
                        }
                        list_show.getItems().clear();
                        list_show.getItems().addAll(str);
                    }
                }
            }
        }
    }
    //this method used when we want to want to find index of p,s,l,c of arraylists with id and type (p,s,l,c)
    void indexFinder(int id,String type){
        if (type.equals("collage")){
            for (int i=0;i<collages_arr.size();i++)
                if (collages_arr.get(i).getID()==id)
                    row_index=i;
        } else if(type.equals("professor")){
            for (int i=0;i<professors_arr.size();i++){
                if (professors_arr.get(i).getID()==id)
                    row_index=i;
            }
        } else if (type.equals("student")) {
            for (int i=0;i<students_arr.size();i++){
                if (students_arr.get(i).getID()==id)
                    row_index=i;
            }
        } else if (type.equals("lesson")){
            for (int i=0;i<lessons_arr.size();i++){
                if (lessons_arr.get(i).getID()==id)
                    row_index=i;
            }
        }
    }
    //this method used when we want to save student evaulation
    @FXML void save_evo(ActionEvent event) {
        if (!professor_evo.getText().equals("")){
            int ch=1;
            for (int i=0;i<students_arr.get(row_index).getEvoName().size();i++){
                if (students_arr.get(row_index).getEvoName().get(i).equals(lesson_evo.getValue())){
                    ch=0;
                }
            }
            if (ch==1) {
                students_arr.get(row_index).setEvoName(lesson_evo.getValue());
                int[] arr = {(int) slider_1.getValue(), (int) slider_2.getValue(), (int) slider_3.getValue(), (int) slider_4.getValue(), (int) slider_5.getValue()};
                students_arr.get(row_index).setEvo(arr);
            }
        }
    }
    //this methos used when we click on checkbox in lesson add page to controll lessonunits
    @FXML void lab(ActionEvent event) {
        if (lab.isSelected()){
            archor_add_l.getChildren().removeAll(lessonUnit_l,lessonUnit_text);
        }else {
            archor_add_l.getChildren().addAll(lessonUnit_l,lessonUnit_text);
        }
    }





//there is 4 part of methods and they are similar (add,search,delete)
//add=>we use this mthods to add p,s,l,c to arraylist and table
//search=>we use this methods to search in ps,l,c to find them
//delete=>we use delete methods to delete selected rows in p,s,l,c

    //in add methods we have some callbacks. they are used to do action and show in table row
    //in delete methods we used deletearr_ arrays to delete selected row in table (more than 1)
    //in delete methods some times we need to delete some elemets from other arrays, so we delete them from all of them we need to delete
////////////////////////////////////////////////professor////////////////////////////////////////////////////
    @FXML void doAdd_p(ActionEvent event) {
        if (name_p.getText().equals("")){
            error_p.setText("fill the name field!");
        } else if (lastname_p.getText().equals("")) {
            error_p.setText("fill the lastname field!");
        } else if (numterm_p.getText().equals("")) {
            error_p.setText("fill the numterm field!");
        } else if (status_p.getText().equals("")){
            error_p.setText("fill the status field!");
        } else {
            Callback<TableColumn<professor, Void>, TableCell<professor, Void>> del = new Callback<TableColumn<professor, Void>, TableCell<professor, Void>>() {
                @Override
                public TableCell<professor, Void> call(final TableColumn<professor, Void> param) {
                    final TableCell<professor, Void> cell = new TableCell<professor, Void>() {

                        private final CheckBox btn3 = new CheckBox();

                        {
                            btn3.setOnAction(actionEvent -> {
                                int row = getTableView().getItems().get(getIndex()).getID();
                                if (btn3.isSelected()){
                                    deleteArr_p.add(row);
                                } else {
                                    for (int i=0;i<deleteArr_p.size();i++){
                                        if (row==deleteArr_p.get(i)){
                                            deleteArr_p.remove(i);
                                        }
                                    }
                                }

                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Pdel.setCellFactory(del);
            Callback<TableColumn<professor, Void>, TableCell<professor, Void>> lesson = new Callback<TableColumn<professor, Void>, TableCell<professor, Void>>() {
                @Override
                public TableCell<professor, Void> call(final TableColumn<professor, Void> param) {
                    final TableCell<professor, Void> cell = new TableCell<professor, Void>() {
                        private final Button btn3 = new Button("LIST");
                        {
                            btn3.setOnAction(actionEvent -> {
                                archor_list.getChildren().removeAll(list_add,list_choice);
                                archor_list.getChildren().addAll(list_add,list_choice);
                                row_type="lesson";
                                row_ok="professor";
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"professor");
                                archor.getChildren().add(archor_list);
                                list_choice.getItems().clear();
                                list_show.getItems().clear();
                                for (int i=0;i<lessons_arr.size();i++) {
                                    String str = lessons_arr.get(i).getID()+") "+lessons_arr.get(i).getName();
                                    list_choice.getItems().add(str);
                                }
                                list_show.getItems().addAll(professors_arr.get(row_index).getLesson());
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Plesson.setCellFactory(lesson);
            Callback<TableColumn<professor, Void>, TableCell<professor, Void>> grade = new Callback<TableColumn<professor, Void>, TableCell<professor, Void>>() {
                @Override
                public TableCell<professor, Void> call(final TableColumn<professor, Void> param) {
                    final TableCell<professor, Void> cell = new TableCell<professor, Void>() {
                        private final Button btn3 = new Button("SHOW");
                        {
                            btn3.setOnAction(actionEvent -> {
                                archor.getChildren().add(archor_evo_p);
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"professor");
                               double a1=0;
                               double a2=0;
                               double a3=0;
                               double a4=0;
                               double a5=0;
                               int num=0;
                                for (int i=0;i<students_arr.size();i++){
                                    for (int j=0;j<students_arr.get(i).getProfessor().size();j++){
                                        String str = professors_arr.get(row_index).getID()+") "+professors_arr.get(row_index).getName();
                                        if (students_arr.get(i).getProfessor().get(j).equals(str)){
                                            for (int k=0;k<students_arr.get(i).getEvoName().size();k++){
                                                if (students_arr.get(i).getEvoName().get(k).equals(students_arr.get(i).getLesson().get(j))){
                                                    int [] arr = students_arr.get(i).getEvo().get(k);
                                                    a1+=arr[0];
                                                    a2+=arr[1];
                                                    a3+=arr[2];
                                                    a4+=arr[3];
                                                    a5+=arr[4];
                                                    num++;
                                                }
                                            }
                                        }
                                    }
                                }
                                av_1.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a1/num))));
                                av_2.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a2/num))));
                                av_3.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a3/num))));
                                av_4.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a4/num))));
                                av_5.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a5/num))));
                                Double d = (((a1+a2+a3+a4+a5)/num)/5);
                                av_t.setText(String.valueOf(Double.parseDouble(String.format("%.2f",d))));
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Pgrade.setCellFactory(grade);




            professor professor = new professor(name_p.getText(),lastname_p.getText(),id_p++,numterm_p.getText(),status_p.getText());
            professors_arr.add(professor);
            professor_table.getItems().removeAll(professors_arr);
            professor_table.getItems().addAll(professors_arr);
            archor.getChildren().remove(archor_add_p);
            name_p.setText("");
            lastname_p.setText("");
            status_p.setText("");
            numterm_p.setText("");
        }
    }
    @FXML void search_p(ActionEvent event) {
        String text=search_p.getText();
        if (!text.equals("")){
            professor_table.getItems().removeAll(professors_arr);
            for (int i=0;i<professors_arr.size();i++){
                if (professors_arr.get(i).getLastName().equals(text)){
                    professor_table.getItems().add(professors_arr.get(i));
                }
            }
        }else {
            professor_table.getItems().removeAll(professors_arr);
            professor_table.getItems().addAll(professors_arr);
        }
    }
    @FXML void delete_p(ActionEvent event) {
        professor_table.getItems().removeAll(professors_arr);
        for (int i=0;i<deleteArr_p.size();i++){
            for (int j=0;j<professors_arr.size();j++){
                if (deleteArr_p.get(i)==professors_arr.get(j).getID()){

                    for (int k=0;k<collages_arr.size();k++){
                        for (int o=0;o<collages_arr.get(k).getProfessor().size();o++){
                            String str = professors_arr.get(j).getID()+") "+professors_arr.get(j).getName();
                            if (str.equals(collages_arr.get(k).getProfessor().get(o))){
                                collages_arr.get(k).getProfessor().remove(o);
                            }
                        }
                    }

                    for (int k=0;k<students_arr.size();k++){
                        for (int o=0;o<students_arr.get(k).getProfessor().size();o++){
                            String str = professors_arr.get(j).getID()+") "+professors_arr.get(j).getName();
                            if (str.equals(students_arr.get(k).getProfessor().get(o))){
                                students_arr.get(k).getProfessor().remove(o);
                                students_arr.get(k).getLesson().remove(o);
                            }
                        }
                    }
                    professors_arr.remove(j);
                }
            }
        }
        deleteArr_p.clear();
        professor_table.getItems().addAll(professors_arr);
    }

///////////////////////////////////////////////lesson/////////////////////////////////////////////////////
    @FXML void doAdd_l(ActionEvent event) {
        if (name_l.getText().equals("")){
            error_l.setText("fill the name field!");
        } else if (lessonUnit_l.getText().equals("") && !lab.isSelected()) {
            error_l.setText("fill the lessonUnit field!");
        } else {
            Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>> cellFactory3 = new Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>>() {
                @Override
                public TableCell<lesson, Void> call(final TableColumn<lesson, Void> param) {
                    final TableCell<lesson, Void> cell = new TableCell<lesson, Void>() {

                        private final CheckBox btn3 = new CheckBox();

                        {
                            btn3.setOnAction(actionEvent -> {
                                int row = getTableView().getItems().get(getIndex()).getID();
                                if (btn3.isSelected()){
                                    if (deleteArr_l.size()==0)
                                        deleteArr_l.add(row);
                                    else{
                                        for (int i=0;i<deleteArr_l.size();i++){
                                            if (row==deleteArr_l.get(i))
                                                break;
                                            else if (i==deleteArr_l.size()-1){
                                                deleteArr_l.add(row);
                                            }
                                        }
                                    }
                                }else {
                                    for (int i=0;i<deleteArr_l.size();i++){
                                        if (row==deleteArr_l.get(i)){
                                            deleteArr_l.remove(i);
                                        }
                                    }
                                }

                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Ldel.setCellFactory(cellFactory3);
            Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>> collage = new Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>>() {
                @Override
                public TableCell<lesson, Void> call(final TableColumn<lesson, Void> param) {
                    final TableCell<lesson, Void> cell = new TableCell<lesson, Void>() {
                        private final Button btn3 = new Button("LIST");
                        {
                            btn3.setOnAction(actionEvent -> {
                                archor_list.getChildren().removeAll(list_add,list_choice,list_professor);
                                row_type="student";
                                row_ok="lesson";
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"lesson");
                                archor.getChildren().add(archor_list);
                                list_show.getItems().clear();
                                for (int i=0;i<collages_arr.size();i++){
                                    for (int j=0;j<collages_arr.get(i).getLesson().size();j++){
                                          if (collages_arr.get(i).getLesson().get(j).equals(row+") "+lessons_arr.get(row_index).getName())){
                                            list_show.getItems().add(collages_arr.get(i).getID()+") "+collages_arr.get(i).getName());
                                        }
                                    }
                                }
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Lcollage.setCellFactory(collage);
            Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>> professor = new Callback<TableColumn<lesson, Void>, TableCell<lesson, Void>>() {
                @Override
                public TableCell<lesson, Void> call(final TableColumn<lesson, Void> param) {
                    final TableCell<lesson, Void> cell = new TableCell<lesson, Void>() {
                        private final Button btn3 = new Button("LIST");
                        {
                            btn3.setOnAction(actionEvent -> {
                                archor_list.getChildren().removeAll(list_add,list_choice,list_professor);
                                row_type="student";
                                row_ok="lesson";
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"lesson");
                                archor.getChildren().add(archor_list);
                                list_show.getItems().clear();
                                for (int i=0;i<professors_arr.size();i++){
                                    for (int j=0;j<professors_arr.get(i).getLesson().size();j++){
                                          if (professors_arr.get(i).getLesson().get(j).equals(row+") "+lessons_arr.get(row_index).getName())){
                                            list_show.getItems().add(professors_arr.get(i).getID()+") "+professors_arr.get(i).getName());
                                        }
                                    }
                                }
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Lprofessor.setCellFactory(professor);

            lesson lesson;
            if (lab.isSelected()) {
                lesson = new lessonLab(id_l++, "1", name_l.getText());
            } else {
                lesson = new lesson(id_l++, lessonUnit_l.getText(), name_l.getText());
            }
            lessons_arr.add(lesson);
            lesson_table.getItems().removeAll(lessons_arr);
            lesson_table.getItems().addAll(lessons_arr);
            archor.getChildren().remove(archor_add_l);
            name_l.setText("");
            lessonUnit_l.setText("");
        }
    }
    @FXML void search_l(ActionEvent event) {
        String text=search_l.getText();
        if (!text.equals("")){
            lesson_table.getItems().removeAll(lessons_arr);
            for (int i=0;i<lessons_arr.size();i++){
                if (lessons_arr.get(i).getName().equals(text)){
                    lesson_table.getItems().add(lessons_arr.get(i));
                }
            }
        }else {
            lesson_table.getItems().removeAll(lessons_arr);
            lesson_table.getItems().addAll(lessons_arr);
        }
    }
    @FXML void delete_l(ActionEvent event) {
        lesson_table.getItems().removeAll(lessons_arr);
        for (int i=0;i<deleteArr_l.size();i++){
            for (int j=0;j<lessons_arr.size();j++){
                if (deleteArr_l.get(i)==lessons_arr.get(j).getID()){

                    for (int k=0;k<collages_arr.size();k++){
                        for (int o=0;o<collages_arr.get(k).getLesson().size();o++){
                            String str = lessons_arr.get(j).getID()+") "+lessons_arr.get(j).getName();
                            if (str.equals(collages_arr.get(k).getLesson().get(o))){
                                collages_arr.get(k).getLesson().remove(o);
                            }
                        }
                    }

                    for (int k=0;k<professors_arr.size();k++){
                        for (int o=0;o<professors_arr.get(k).getLesson().size();o++){
                            String str = lessons_arr.get(j).getID()+") "+lessons_arr.get(j).getName();
                            if (str.equals(professors_arr.get(k).getLesson().get(o))){
                                professors_arr.get(k).getLesson().remove(o);
                            }
                        }
                    }

                    for (int k=0;k<students_arr.size();k++){
                        for (int o=0;o<students_arr.get(k).getLesson().size();o++){
                            String str = lessons_arr.get(j).getID()+") "+lessons_arr.get(j).getName();
                            if (str.equals(students_arr.get(k).getLesson().get(o))){
                                students_arr.get(k).getLesson().remove(o);
                                students_arr.get(k).getProfessor().remove(o);
                            }
                        }
                    }
                    lessons_arr.remove(j);
                }
            }
        }
        deleteArr_l.clear();
        lesson_table.getItems().addAll(lessons_arr);
    }

///////////////////////////////////////////////student/////////////////////////////////////////////////////
    @FXML void doAdd_s(ActionEvent event) {
        if (name_s.getText().equals("")){
            error_s.setText("fill the name field!");
        } else if (lastname_s.getText().equals("")) {
            error_s.setText("fill the lastname field!");
        } else if(collage_s==null){
            error_s.setText("choose the collage");
        }else {
            Callback<TableColumn<student, Void>, TableCell<student, Void>> delete = new Callback<TableColumn<student, Void>, TableCell<student, Void>>() {
                @Override
                public TableCell<student, Void> call(final TableColumn<student, Void> param) {
                    final TableCell<student, Void> cell = new TableCell<student, Void>() {

                        private final CheckBox btn3 = new CheckBox();

                        {
                            btn3.setOnAction(actionEvent -> {
                                int row = getTableView().getItems().get(getIndex()).getID();
                                if (btn3.isSelected()){
                                    if (deleteArr_s.size()==0)
                                        deleteArr_s.add(row);
                                    else{
                                        for (int i=0;i<deleteArr_s.size();i++){
                                            if (row==deleteArr_s.get(i))
                                                break;
                                            else if (i==deleteArr_s.size()-1){
                                                deleteArr_s.add(row);
                                            }
                                        }
                                    }
                                }else {
                                    for (int i=0;i<deleteArr_s.size();i++){
                                        if (row==deleteArr_s.get(i)){
                                            deleteArr_s.remove(i);
                                        }
                                    }
                                }

                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Sdel.setCellFactory(delete);

            Callback<TableColumn<student, Void>, TableCell<student, Void>> lesson = new Callback<TableColumn<student, Void>, TableCell<student, Void>>() {
                @Override
                public TableCell<student, Void> call(final TableColumn<student, Void> param) {
                    final TableCell<student, Void> cell = new TableCell<student, Void>() {
                        private final Button btn3 = new Button("LIST");
                        {
                            btn3.setOnAction(actionEvent -> {
                                archor_list.getChildren().removeAll(list_add,list_choice);
                                archor_list.getChildren().addAll(list_professor,list_add,list_choice);
                                row_type="lesson";
                                row_ok="student";
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"student");
                                archor.getChildren().add(archor_list);
                                list_choice.getItems().clear();
                                list_show.getItems().clear();
                                for (int i = 0; i < collages_arr.size(); i++) {
                                    for (int j = 0; j < collages_arr.get(i).getStudent().size(); j++) {
                                        String str = students_arr.get(row_index).getID()+") "+students_arr.get(row_index).getName();
                                        if (collages_arr.get(i).getStudent().get(j).equals(str)){
                                            list_choice.getItems().addAll(collages_arr.get(i).getLesson());
                                            break;
                                        }
                                    }
                                }
                                list_choice.getSelectionModel().selectedItemProperty().addListener(( observableValue, old, newval) -> {
                                    list_professor.getItems().clear();
                                    for (int i=0;i<professors_arr.size();i++) {
                                        for (int j=0;j<professors_arr.get(i).getLesson().size();j++){
                                            if (professors_arr.get(i).getLesson().get(j).equals(newval)){
                                                String str = professors_arr.get(i).getID()+") "+professors_arr.get(i).getName();
                                                list_professor.getItems().add(str);
                                            }
                                        }
                                    }
                                });

                                ArrayList<String> str = new ArrayList<>();
                                for (int i=0;i<students_arr.get(row_index).getLesson().size();i++){
                                    str.add(students_arr.get(row_index).getLesson().get(i)+" => "+students_arr.get(row_index).getProfessor().get(i));

                                }
                                list_show.getItems().addAll(str);
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Slesson.setCellFactory(lesson);

            Callback<TableColumn<student, Void>, TableCell<student, Void>> evaluation = new Callback<TableColumn<student, Void>, TableCell<student, Void>>() {
                @Override
                public TableCell<student, Void> call(final TableColumn<student, Void> param) {
                    final TableCell<student, Void> cell = new TableCell<student, Void>() {
                        private final Button btn3 = new Button("LIST");
                        {
                            btn3.setOnAction(actionEvent -> {
                                int row = getTableView().getItems().get(getIndex()).getID();
                                indexFinder(row,"student");
                                archor.getChildren().add(archor_evo);
                                lesson_evo.getItems().clear();
                                slider_1.setValue(1);
                                slider_2.setValue(1);
                                slider_3.setValue(1);
                                slider_4.setValue(1);
                                slider_5.setValue(1);
                                professor_evo.setText("");
                                save_evo.setStyle("-fx-background-color: #393d39;-fx-text-fill: #a8a7a7");
                                save_evo.setCursor(Cursor.DEFAULT);

                                for (int i=0;i<students_arr.get(row_index).getLesson().size();i++) {
                                    String str = students_arr.get(row_index).getLesson().get(i);
                                    lesson_evo.getItems().add(str);
                                }
                                lesson_evo.getSelectionModel().selectedItemProperty().addListener(( observableValue, old, newval) -> {
                                    slider_1.setValue(1);
                                    slider_2.setValue(1);
                                    slider_3.setValue(1);
                                    slider_4.setValue(1);
                                    slider_5.setValue(1);
                                    professor_evo.setText("");
                                    save_evo.setStyle("-fx-background-color: #393d39;-fx-text-fill: #a8a7a7");
                                    save_evo.setCursor(Cursor.DEFAULT);

                                    for (int i=0;i<students_arr.size();i++){
                                        for (int j=0;j<students_arr.get(i).getLesson().size();j++){
                                            if (students_arr.get(i).getLesson().get(j).equals(newval)){
                                                professor_evo.setText(students_arr.get(i).getProfessor().get(j));
                                                if (students_arr.get(row_index).getEvoName().size()==0){
                                                    save_evo.setStyle("-fx-background-color: #10c210;-fx-text-fill: #067906");
                                                    save_evo.setCursor(Cursor.HAND);
                                                }
                                                for (int k=0;k<students_arr.get(row_index).getEvoName().size();k++){
                                                    if (students_arr.get(row_index).getEvoName().get(k).equals(lesson_evo.getValue())){
                                                        int [] slide_arr=students_arr.get(row_index).getEvo().get(k);
                                                        slider_1.setValue(slide_arr[0]);
                                                        slider_2.setValue(slide_arr[1]);
                                                        slider_3.setValue(slide_arr[2]);
                                                        slider_4.setValue(slide_arr[3]);
                                                        slider_5.setValue(slide_arr[4]);
                                                        break;
                                                    }else if (k==students_arr.get(row_index).getEvoName().size()-1){
                                                        save_evo.setStyle("-fx-background-color: #10c210;-fx-text-fill: #067906");
                                                        save_evo.setCursor(Cursor.HAND);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn3);
                            }
                        }
                    };
                    return cell;
                }
            };
            Sevaluation.setCellFactory(evaluation);


            for (int i = 0; i < collages_arr.size(); i++) {
                if (collages_arr.get(i).getName().equals(collage_s.getValue())){
                    collages_arr.get(i).setStudent(id_s+") "+name_s.getText());
                    break;
                }
            }
            student student = new student(id_s++,name_s.getText(),lastname_s.getText());
            students_arr.add(student);
            student_table.getItems().removeAll(students_arr);
            student_table.getItems().addAll(students_arr);
            archor.getChildren().remove(archor_add_s);
            name_s.setText("");
            lastname_s.setText("");
        }
    }
    @FXML void search_s(ActionEvent event) {
        String text=search_s.getText();
        if (!text.equals("")){
            student_table.getItems().removeAll(students_arr);
            for (int i=0;i<students_arr.size();i++){
                if (students_arr.get(i).getLastName().equals(text)){
                    student_table.getItems().add(students_arr.get(i));
                }
            }
        }else {
            student_table.getItems().removeAll(students_arr);
            student_table.getItems().addAll(students_arr);
        }
    }
    @FXML void delete_s(ActionEvent event) {
        student_table.getItems().removeAll(students_arr);
        for (int i=0;i<deleteArr_s.size();i++){
            for (int j=0;j<students_arr.size();j++){
                if (deleteArr_s.get(i)==students_arr.get(j).getID()){

                    for (int k=0;k<collages_arr.size();k++){
                        for (int o=0;o<collages_arr.get(k).getStudent().size();o++){
                            String str = students_arr.get(j).getID()+") "+students_arr.get(j).getName();
                            if (str.equals(collages_arr.get(k).getStudent().get(o))){
                                collages_arr.get(k).getStudent().remove(o);
                            }
                        }
                    }
                    students_arr.remove(j);
                }
            }
        }
        deleteArr_s.clear();
        student_table.getItems().addAll(students_arr);
    }

///////////////////////////////////////////////collage/////////////////////////////////////////////////////
    @FXML void doAdd_c(ActionEvent event) {
    if (name_c.getText().equals("")){
        error_c.setText("fill the name field!");
    } else {
        Callback<TableColumn<collage, Void>, TableCell<collage, Void>> del = new Callback<TableColumn<collage, Void>, TableCell<collage, Void>>() {
            @Override
            public TableCell<collage, Void> call(final TableColumn<collage, Void> param) {
                final TableCell<collage, Void> cell = new TableCell<collage, Void>() {
                    private final CheckBox btn3 = new CheckBox();
                    {
                        btn3.setOnAction(actionEvent -> {
                            int row = getTableView().getItems().get(getIndex()).getID();
                            if (btn3.isSelected()){
                                if (deleteArr_c.size()==0)
                                    deleteArr_c.add(row);
                                else{
                                    for (int i=0;i<deleteArr_c.size();i++){
                                        if (row==deleteArr_c.get(i))
                                            break;
                                        else if (i==deleteArr_c.size()-1){
                                            deleteArr_c.add(row);
                                        }
                                    }
                                }
                            }else {
                                for (int i=0;i<deleteArr_c.size();i++){
                                    if (row==deleteArr_c.get(i)){
                                        deleteArr_c.remove(i);
                                    }
                                }
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn3);
                        }
                    }
                };
                return cell;
            }
        };
        Cdel.setCellFactory(del);

        Callback<TableColumn<collage, Void>, TableCell<collage, Void>> lesson = new Callback<TableColumn<collage, Void>, TableCell<collage, Void>>() {
            @Override
            public TableCell<collage, Void> call(final TableColumn<collage, Void> param) {
                final TableCell<collage, Void> cell = new TableCell<collage, Void>() {
                    private final Button btn3 = new Button("LIST");
                    {
                        btn3.setOnAction(actionEvent -> {
                            archor_list.getChildren().removeAll(list_add,list_choice);
                            archor_list.getChildren().addAll(list_add,list_choice);
                            row_type="lesson";
                            row_ok="collage";
                            int row = getTableView().getItems().get(getIndex()).getID();
                            indexFinder(row,"collage");
                            archor.getChildren().add(archor_list);
                            list_choice.getItems().clear();
                            list_show.getItems().clear();
                            for (int i=0;i<lessons_arr.size();i++) {
                                String str = lessons_arr.get(i).getID()+") "+lessons_arr.get(i).getName();
                                list_choice.getItems().add(str);
                            }
                            list_show.getItems().addAll(collages_arr.get(row_index).getLesson());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn3);
                        }
                    }
                };
                return cell;
            }
        };
        Clesson.setCellFactory(lesson);

        Callback<TableColumn<collage, Void>, TableCell<collage, Void>> professor = new Callback<TableColumn<collage, Void>, TableCell<collage, Void>>() {
            @Override
            public TableCell<collage, Void> call(final TableColumn<collage, Void> param) {
                final TableCell<collage, Void> cell = new TableCell<collage, Void>() {
                    private final Button btn3 = new Button("LIST");
                    {
                        btn3.setOnAction(actionEvent -> {
                            archor_list.getChildren().removeAll(list_add,list_choice);
                            archor_list.getChildren().addAll(list_add,list_choice);
                            row_type="professor";
                            row_ok="collage";
                            int row = getTableView().getItems().get(getIndex()).getID();
                            indexFinder(row,"collage");
                            archor.getChildren().add(archor_list);
                            list_choice.getItems().clear();
                            list_show.getItems().clear();
                            for (int i=0;i<professors_arr.size();i++) {
                                String str = professors_arr.get(i).getID()+") "+professors_arr.get(i).getName();
                                list_choice.getItems().add(str);
                            }
                            list_show.getItems().addAll(collages_arr.get(row_index).getProfessor());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn3);
                        }
                    }
                };
                return cell;
            }
        };
        Cprofessor.setCellFactory(professor);

        Callback<TableColumn<collage, Void>, TableCell<collage, Void>> student = new Callback<TableColumn<collage, Void>, TableCell<collage, Void>>() {
            @Override
            public TableCell<collage, Void> call(final TableColumn<collage, Void> param) {
                final TableCell<collage, Void> cell = new TableCell<collage, Void>() {
                    private final Button btn3 = new Button("LIST");
                    {
                        btn3.setOnAction(actionEvent -> {
                            archor_list.getChildren().removeAll(list_add,list_choice);
                            row_type="student";
                            row_ok="collage";
                            int row = getTableView().getItems().get(getIndex()).getID();
                            indexFinder(row,"collage");
                            archor.getChildren().add(archor_list);
                            list_show.getItems().clear();
                            list_show.getItems().addAll(collages_arr.get(row_index).getStudent());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn3);
                        }
                    }
                };
                return cell;
            }
        };
        Cstudent.setCellFactory(student);

        Callback<TableColumn<collage, Void>, TableCell<collage, Void>> detail = new Callback<TableColumn<collage, Void>, TableCell<collage, Void>>() {
            @Override
            public TableCell<collage, Void> call(final TableColumn<collage, Void> param) {
                final TableCell<collage, Void> cell = new TableCell<collage, Void>() {
                    private final Button btn3 = new Button("SHOW");
                    {
                        btn3.setOnAction(actionEvent -> {
                            archor.getChildren().addAll(archor_evo_c);
                            int row = getTableView().getItems().get(getIndex()).getID();
                            indexFinder(row,"collage");
                            best_professor.setText("NaN");
                            double a1=0;
                            double a2=0;
                            double a3=0;
                            double a4=0;
                            double a5=0;
                            int count=collages_arr.get(row_index).getProfessor().size();
                            double ch=0;
                            double max=0;
                            for (int i=0;i<count;i++){
                                int p1=0;
                                int p2=0;
                                int p3=0;
                                int p4=0;
                                int p5=0;
                                int p_s=0;
                                for (int j=0;j<students_arr.size();j++){
                                    for (int k=0;k<students_arr.get(j).getProfessor().size();k++){
                                        if (collages_arr.get(row_index).getProfessor().get(i).equals(students_arr.get(j).getProfessor().get(k))){
                                            for (int p=0;p<students_arr.get(j).getEvoName().size();p++){
                                                if (students_arr.get(j).getEvoName().get(p).equals(students_arr.get(j).getLesson().get(k))){
                                                    int [] arr = students_arr.get(j).getEvo().get(p);
                                                    p1+=arr[0];
                                                    p2+=arr[1];
                                                    p3+=arr[2];
                                                    p4+=arr[3];
                                                    p5+=arr[4];
                                                    p_s++;
                                                }
                                            }
                                        }
                                    }
                                }
                                p1/=p_s;
                                p2/=p_s;
                                p3/=p_s;
                                p4/=p_s;
                                p5/=p_s;

                                a1+=p1;
                                a2+=p2;
                                a3+=p3;
                                a4+=p4;
                                a5+=p5;
                                ch=p1+p2+p3+p4+p5;
                                if (ch > max){
                                    best_professor.setText(collages_arr.get(row_index).getProfessor().get(i));
                                    max=ch;
                                }

                            }
                            avc_1.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a1/count))));
                            avc_2.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a2/count))));
                            avc_3.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a3/count))));
                            avc_4.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a4/count))));
                            avc_5.setText(String.valueOf(Double.parseDouble(String.format("%.2f",a5/count))));
                            Double d = (((a1+a2+a3+a4+a5)/count)/5);
                            avc_t.setText(String.valueOf(Double.parseDouble(String.format("%.2f",d))));
                            count_professor.setText(String.valueOf(count));

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn3);
                        }
                    }
                };
                return cell;
            }
        };
        Cdetail.setCellFactory(detail);




        collage collage = new collage(id_c++,name_c.getText());
        collages_arr.add(collage);
        collage_table.getItems().removeAll(collages_arr);
        collage_table.getItems().addAll(collages_arr);
        archor.getChildren().remove(archor_add_c);
        name_c.setText("");
    }
}
    @FXML void search_c(ActionEvent event) {
        String text=search_c.getText();
        if (!text.equals("")){
            collage_table.getItems().removeAll(collages_arr);
            for (int i=0;i<collages_arr.size();i++){
                if (collages_arr.get(i).getName().equals(text)){
                    collage_table.getItems().add(collages_arr.get(i));
                }
            }
        }else {
            collage_table.getItems().removeAll(collages_arr);
            collage_table.getItems().addAll(collages_arr);
        }
    }
    @FXML void delete_c(ActionEvent event) {
        collage_table.getItems().removeAll(collages_arr);
        for (int i=0;i<deleteArr_c.size();i++){
            for (int j=0;j<collages_arr.size();j++){
                if (deleteArr_c.get(i)==collages_arr.get(j).getID()){
                    collages_arr.remove(j);
                }
            }
        }
        deleteArr_c.clear();
        collage_table.getItems().addAll(collages_arr);
    }

}