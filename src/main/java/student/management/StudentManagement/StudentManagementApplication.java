// Mapを作って新規登録で名前と年齢を登録していく
//Mapの複数の情報の更新や片方のみの更新をやってみる

package student.management.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

    private String name;
    private String age;
    private Map<String, String> personalData = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);

    }

    //入力フォーム
    @GetMapping("/userInput")
    public String userInput() {
        return "氏名:" + name + " " + "年齢:" + age + "歳";
    }

    //入力の受け取りとMapへの追加処理
    @PostMapping("/userInput")
    public void userDate(String name, String age) {
        this.name = name;
        this.age = age;
        personalData.put(name, age);
    }
    //一覧表示
    @GetMapping("/userDateMap")
    @ResponseBody
    public Map<String, String> userMap() {
        return personalData;
    }


    //下記講座内容
    /*@GetMapping("/studentInfo")
    public String getStudentInfo() {
        return name + " " + age + "歳";
    }
    //↓これでもOK
	/*@GetMapping("/age")
	public String getAge("/){
		return age;
	}*/

    /*@PostMapping("/studentInfo")
    //複数の引数の場合　＆で渡せる
    public void setStudentInfo(String name, String age) {
        this.name = name;
        this.age = age;
    }
    //GETとPOST(大文字で書くことが多い)
    //GETは取得する、リクエストの結果を受け取る
    //POSTは（リクエストに）情報を与える、渡す

    @PostMapping("/studentName")
    public void updateStudentName(String name) {
        this.name = name;
    }
    //↑は講義内容　nameのみ更新とあるがageがnullになってします
    //Geminiで聞くとSpringBootのverの違いかもと　↓のようにnullじゃない場合と明示したほうがいいとのこと
	/*@PostMapping("/studentName")
	public void updateStudentName(String name, @RequestParam(required = false)String age) {
		this.name = name;
		if (age != null) {
			this.age = age;
		}*/
}
