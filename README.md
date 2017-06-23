# AndroidFrameworkClassify
ButterKnife Easy Wear!
1、ButterKnife使用

【
网上最新的依赖是8…的，如果添加不了依赖就添加如下版本较低的6…..。
添加对应的工具+compile 'com.jakewharton:butterknife:6.1.0'‘
compile 'com.jakewharton:butterknife:8.1.0'
在Android Studio中添加：ButterKnifeZelezny插件。
初始化：ButterKnife.inject(this);

1、下载插件：




2、添加依赖

     以一个简单的项目作为实例：
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:'+gradle.ext.compileSupportversion
    testCompile 'junit:junit:4.12'

//    compile 'com.jakewharton:butterknife:8.1.0'

    compile 'com.jakewharton:butterknife:8.4.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'

}

简单布局：
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.xys.butterknifetest.MainActivity">

    <TextView
        android:id="@+id/tv_show"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:text="Hello World!"/>

    <ImageView
        android:id="@+id/img_show"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/tv_show"
        android:layout_marginTop="20dp"
        android:background="@mipmap/ic_launcher"/>

    <Button
        android:id="@+id/btn1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/img_show"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:text="事件1"/>

    <Button
        android:id="@+id/btn2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/btn1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:text="事件2"/>


    <Button
        android:id="@+id/btn3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/btn2"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:text="事件3"/>




</RelativeLayout>



3、实例代码和操作演示：
     首先完成初始化操作：
ButterKnife.bind(this);

-------》快速生成应用资源代码：
setContentView(R.layout.activity_main);
光标选中布局文件，右击：


下一步：


快速可视化界面如下：


功能性实例代码：

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {


    @BindView(R.id.tv_show)
    TextView mTvShow;
    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick(R.id.btn1)
    public void onMBtn1Clicked() {
        mTvShow.setText("事件1触发");
        Toast.makeText(this, "事件1触发", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn2)
    public void onMBtn2Clicked() {
        mTvShow.setText("事件2触发");
        Toast.makeText(this, "事件2触发", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn3)
    public void onMBtn3Clicked() {
        mTvShow.setText("事件3触发");
        Toast.makeText(this, "事件3触发", Toast.LENGTH_SHORT).show();
    }
}

4、理论说明
===关于ButterKnife服务注册：
     在Activity上使用 ButterKnife.bind(this)
     在非Activity上使用ButterKnife.bind(this,view)

===绑定View控件：
/**单个View控件的绑定*/
@BindView(R.id.btn_login)
/**多个控件的绑定可以写在List或者Array中*/
@BindViews({ R.id.first_name, R.id.middle_name, R.id.last_name })
List<EditText> nameViews;

===资源绑定
@BindString(R.string.title) String title;
@BindDrawable(R.drawable.graphic) Drawable graphic;
@BindColor(R.color.red) int red; // int or ColorStateList field
@BindDimen(R.dimen.spacer) Float spacer; // int (for pixel size) or float (for exact value) field

===监听器绑定
@OnClick(R.id.btn3)
public void onMBtn3Clicked() {
    mTvShow.setText("事件3触发");
    Toast.makeText(this, "事件3触发", Toast.LENGTH_SHORT).show();
}
--多个控件可以绑定同一个监听器
@OnClick(R.id.btn3,R.id.btn5)
public void onMBtn3Clicked() {
    mTvShow.setText("事件3触发");
    Toast.makeText(this, "事件3触发", Toast.LENGTH_SHORT).show();
}

===Fragment重置Binding
Fragment的生命周期不同于Activity,当Butterknife在onCreateView上进行绑定时，需要再onDestroyView上进行解绑,Butterknife.bind()方法提供了一个Unbinder 返回值，在onDestroyView上调用相关的unbinder方法即可:
public class FancyFragment extends Fragment {
@BindView(R.id.button1) Button button1; 
@BindView(R.id.button2) Button button2;
private Unbinder unbinder; 
@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
    View view = inflater.inflate(R.layout.fancy_fragment, container,false); 
    unbinder = ButterKnife.bind(this, view); 
// TODO Use fields... return view; 
} 
@Override public void onDestroyView() { 
    super.onDestroyView(); 
    unbinder.unbind(); 
}}

】











