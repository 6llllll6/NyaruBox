package com.example.nyarubox;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    //定义登录Button 编辑框
    private Button btn_login;
    private EditText et_password,et_userName;
    /*定义数据库所需成员变量 */
    private DBOpenHelper dbOpenHelper;
    //数据库里存储的password
    String dbpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ListView test_text=(ListView)findViewById(R.id.test_text);
        //初始化
        initView();
        //注册完之后更新

        /*定义数据库对象 */
        dbOpenHelper=new DBOpenHelper(LoginActivity.this,"user.db",null,1);

        /*点击跳转至注册页面 【还没有账号？点击注册】按钮*/
        Button btn_register1=(Button)findViewById(R.id.btn_register1);
        btn_register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击按钮跳转到注册页面
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                //注册返回代码为0时，跳转
                startActivity(intent);
            }
        });

        //登录按钮单击事件
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的密码框内容
                String etpassword=et_password.getText().toString();
                /*获取数据库里的数据*/
                //登录按钮获取要查询的账号
                String key=et_userName.getText().toString();
                Cursor cursor=dbOpenHelper.getReadableDatabase().query("user",null,"username = ?",new String[]{key},null,null,null);
                //创建ArrayList对象，用于保存用户数据结果
                ArrayList<Map<String,String>> resultList =new ArrayList<Map<String,String>>();//不用测试的话，直接遍历取值getstring（2）就行，创建数组可以省去。
                while(cursor.moveToNext()){
                    //将结果集中的数据存入HashMap
                    Map<String,String> map=new HashMap<>();
                    //取出查询结果第二列和第三列的值
                    //用户名
                    map.put("username",cursor.getString(1));
                    //密码
                    map.put("password",cursor.getString(2));
                    resultList.add(map);

                    //获取数据库中符合用户名的对应的密码
                    dbpassword=map.get("password");
                }
                //正则化判断输入的账号是否符合手机号格式
                if(!isTelPhoneNumber(key)){
                    Toast.makeText(LoginActivity.this,"请输入正确的手机号！",Toast.LENGTH_SHORT).show();
                }else if (resultList == null || resultList.size() == 0) { //如果数据库中没有查询的用户数据
                    //显示提示信息，没有相关记录
                    Toast.makeText(LoginActivity.this,
                            "该用户名未注册，请先注册", Toast.LENGTH_LONG).show();
                } else {
                /*R.layout.userdata_main、R.id.result_name, R.id.result_grade
                这里的是我登录页面里面有个测试框用来显示数据库中符合输入的用户名的结果的
                等会写在下面把 只有一个userdata_main.xml */
//                    SimpleAdapter simpleAdapter= new SimpleAdapter(LoginActivity.this, resultList,
//                            R.layout.userdata_main, new String[]{"username", "password"}, new int[]{R.id.result_name, R.id.result_grade});
                    //将适配器和测试的listview关联，我这里的listview叫test_text
 //                   test_text.setAdapter(simpleAdapter);

                    //查到了用户 对比输入的密码与数据库的密码是否一致 如果相等跳转到主页面去
                    if(etpassword.equals(dbpassword)){
                        Toast.makeText(LoginActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                        //跳转到Mainactivity
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        //关闭登录页面
                        LoginActivity.this.finish();
                    }else{
                        Toast.makeText(LoginActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });
    }
    /*正则化验证手机号码*/
    public static boolean isTelPhoneNumber(String mobile) {
        if (mobile != null && mobile.length() == 11) {
            Pattern pattern = Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$");
            Matcher matcher = pattern.matcher(mobile);
            return matcher.matches();
        }else{
            return false;
        }
    }
    //定义初始化
    private void initView(){
        btn_login=findViewById(R.id.btn_login);
        et_userName=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
    }

    //    //重写onDestroy()方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbOpenHelper != null) {
            dbOpenHelper.close();
        }
    }
}
