FragmentTabHost Demo
===
1、
-










Bug
===
//B bugs,D debug

B1:android.app.Fragment 与android.support.v4.app.Fragment 不一致。如果用 android.support.v4.app.Fragment 则统一用android.support.v4.app.Fragment包。

    java.lang.ClassCastException: FragmentOne cannot be cast to android.support.v4.app.Fragment
D1:在FragmentOne 类中，将更换导入包。
import android.support.v4.app.Fragment;  
//android:app.Fragment

B2：

D2：