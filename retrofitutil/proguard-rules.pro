## Add project specific ProGuard rules here.
## By default, the flags in this file are appended to flags specified
## in D:\AndroidStudio\sdk/tools/proguard/proguard-android.txt
## You can edit the include path and order by changing the proguardFiles
## directive in build.gradle.
##
## For more details, see
##   http://developer.android.com/guide/developing/tools/proguard.html
#
## Add any project specific keep options here:
#
## If your project uses WebView with JS, uncomment the following
## and specify the fully qualified class name to the JavaScript interface
## class:
##-keepclassmembers class fqcn.of.javascript.interface.for.webview {
##   public *;
##}
#
#    -optimizationpasses 5                                                           # 指定代码的压缩级别
#    -dontusemixedcaseclassnames                                                     # 是否使用大小写混合
#    -dontskipnonpubliclibraryclasses                                                # 是否混淆第三方jar
#    -dontpreverify                                                                  # 混淆时是否做预校验
#    -verbose                                                                        # 混淆时是否记录日志
#    -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*        # 混淆时所采用的算法
#
#    -dontpreverify    #注：代码编译出错的情况下 添加
#    -dontwarn
#
#    -keep public class * extends android.app.Activity                               # 保持哪些类不被混淆
#    -keep public class * extends android.app.Application                            # 保持哪些类不被混淆
#    -keep public class * extends android.app.Service                                # 保持哪些类不被混淆
#    -keep public class * extends android.content.BroadcastReceiver                  # 保持哪些类不被混淆
#    -keep public class * extends android.content.ContentProvider                    # 保持哪些类不被混淆
#    -keep public class * extends android.app.backup.BackupAgentHelper               # 保持哪些类不被混淆
#    -keep public class * extends android.preference.Preference                      # 保持哪些类不被混淆
#    -keep public class com.android.vending.licensing.ILicensingService              # 保持哪些类不被混淆
#
#    -keepclasseswithmembernames class * {                                         # 保持 native 方法不被混淆
#        native <methods>;
#    }
#
#    -keepclasseswithmembers class * {                                               # 保持自定义控件类不被混淆
#        public <init>(android.content.Context, android.util.AttributeSet);
#    }
#
#    -keepclasseswithmembers class * {
#        public <init>(android.content.Context, android.util.AttributeSet, int);     # 保持自定义控件类不被混淆
#    }
#
#    -keepclassmembers class * extends android.app.Activity {                        # 保持自定义控件类不被混淆
#       public void *(android.view.View);
#    }
#
#    -keepclassmembers enum * {                                                      # 保持枚举 enum 类不被混淆
#        public static **[] values();
#        public static ** valueOf(java.lang.String);
#    }
#
#    -keep class * implements android.os.Parcelable {                                # 保持 Parcelable 不被混淆
#      public static final android.os.Parcelable$Creator *;
#    }
#
##    -keep class MyClass;                                                            # 保持自己定义的类不被混淆
#
######################记录生成的日志数据,gradle build时在本项目根目录输出################
#
##apk 包内所有 class 的内部结构
#-dump class_files.txt
##未混淆的类和成员
#-printseeds seeds.txt
##列出从 apk 中删除的代码
#-printusage unused.txt
##混淆前后的映射
#-printmapping mapping.txt
#
######################记录生成的日志数据，gradle build时 在本项目根目录输出-end################
#
##如果有引用v4包可以添加下面这行
#-keep class android.support.v4.** { *; }
#-keep public class * extends android.support.v4.**
#-keep public class * extends android.app.Fragment
#
##如果引用了v4或者v7包，可以忽略警告，因为用不到android.support
#-dontwarn android.support.**
#
##保持自定义组件不被混淆
#-keep public class * extends android.view.View {
#    public <init>(android.content.Context);
#    public <init>(android.content.Context, android.util.AttributeSet);
#    public <init>(android.content.Context, android.util.AttributeSet, int);
#    public void set*(...);
#}
#
##保持 Serializable 不被混淆
#-keepnames class * implements java.io.Serializable
#
##保持 Serializable 不被混淆并且enum 类也不被混淆
#-keepclassmembers class * implements java.io.Serializable {
#    static final long serialVersionUID;
#    private static final java.io.ObjectStreamField[] serialPersistentFields;
#    private void writeObject(java.io.ObjectOutputStream);
#    private void readObject(java.io.ObjectInputStream);
#    java.lang.Object writeReplace();
#    java.lang.Object readResolve();
#}
#
##保持枚举 enum 类不被混淆 如果混淆报错，建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
#-keepclassmembers enum * {
#  public static **[] values();
# public static ** valueOf(java.lang.String);
#}
#
#-keepclassmembers class * {
#    public void *ButtonClicked(android.view.View);
#}
#
##不混淆资源类
#-keepclassmembers class **.R$* {
#    public static <fields>;
#}
#
##xUtils(保持注解，及使用注解的Activity不被混淆，不然会影响Activity中你使用注解相关的代码无法使用)
##        -keep class * extends java.lang.annotation.Annotation {*;}
##        -keep class com.otb.designerassist.activity.** {*;}
#
#
##自己项目特殊处理代码（这些地方我使用了Gson类库和注解，所以不希望被混淆，以免影响程序）
##        -keep class com.otb.designerassist.entity.** {*;}
##        -keep class com.otb.designerassist.http.rspdata.** {*;}
##        -keep class com.otb.designerassist.service.** {*;}
#
#
###混淆保护自己项目的部分代码以及引用的第三方jar包library（想混淆去掉"#"）
##-libraryjars libs/umeng-analytics-v5.2.4.jar
##-libraryjars libs/alipaysecsdk.jar
##-libraryjars libs/alipayutdid.jar
##-libraryjars libs/weibosdkcore.jar
#
## 以libaray的形式引用的图片加载框架,不想混淆（注意，此处不是jar包形式，想混淆去掉"#"）
##-keep class com.nostra13.universalimageloader.** { *; }
#
#
####-------- Gson 相关的混淆配置--------
#-keepattributes Signature
#-keepattributes *Annotation*
#-keep class sun.misc.Unsafe { *; }
#
####-------- ShareSDK 相关的混淆配置---------
##        -keep class cn.sharesdk.** { *; }
##        -keep class com.sina.sso.** { *; }
#
#
####--------------umeng 相关的混淆配置-----------
##        -keep class com.umeng.** { *; }
##        -keep class com.umeng.analytics.** { *; }
##        -keep class com.umeng.common.** { *; }
##        -keep class com.umeng.newxp.** { *; }
#
#
####-------- retrofit 相关的混淆配置---------
#-dontwarn retrofit.**
#-keep class retrofit.** { *; }
#-keepattributes Signature
#-keepattributes Exceptions


    -optimizationpasses 5                                                           # 指定代码的压缩级别
    -dontusemixedcaseclassnames                                                     # 是否使用大小写混合
    -dontskipnonpubliclibraryclasses                                                # 是否混淆第三方jar
    -dontpreverify                                                                  # 混淆时是否做预校验
    -verbose                                                                        # 混淆时是否记录日志
    -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*        # 混淆时所采用的算法

    -dontwarn

#-allowaccessmodification
#-repackageclasses ''】
-keepattributes *Annotation*
-dontwarn android.support.**

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

-dontnote **ILicensingService

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context,android.util.AttributeSet);
    public <init>(android.content.Context,android.util.AttributeSet,int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet,int);
}

-keepclassmembers class * extends android.content.Context {
    public void *(android.view.View);
    public void *(android.view.MenuItem);
}

-keepclassmembers class * extends android.os.Parcelable {
    static ** CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}


#####################记录生成的日志数据,gradle build时在本项目根目录输出################

#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt

#####################记录生成的日志数据，gradle build时 在本项目根目录输出-end################


####-------- Gson 相关的混淆配置--------
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-dontwarn com.google.gson.**
-keep class com.google.gson.** { *; }

####-------- retrofit 相关的混淆配置---------
-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-dontwarn com.blackcat.retrofitutil.**
-keep class com.blackcat.retrofitutil.** { *; }
