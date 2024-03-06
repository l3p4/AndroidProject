plugins {
    id("com.android.application")
}

android {
    namespace = "com.ixuea.courses.mymusic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ixuea.courses.mymusic"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding {
        //开启视图绑定，用来替代findViewById
        //官方文档：https://developer.android.com/topic/libraries/view-binding
        enable = true
    }
}





dependencies {

    implementation ("androidx.preference:preference:1.2.0")
    //如果这里用api,则代表别人可以通过依赖app来调用super-j的公共方法
//    api(project(mapOf("path" to ":super-j")))
//    implementation(project(mapOf("path" to ":super-j")))
//    implementation(project(mapOf("path" to ":super-k")))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //UI框架，主要是用他的工具类，也可以单独拷贝出来
    //https://qmuiteam.com/android/get-started
    implementation ("com.qmuiteam:qmui:2.0.1")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //头条适配屏幕宽度
//    implementation ("com.github.JessYanCoding:AndroidAutoSize:v1.2.1")
  
    //动态处理权限
    //https://github.com/permissions-dispatcher/PermissionsDispatcher
    implementation ("com.github.permissions-dispatcher:permissionsdispatcher:4.9.2")

    annotationProcessor ("com.github.permissions-dispatcher:permissionsdispatcher-processor:4.9.2")
    //存储
    implementation ("com.tencent:mmkv:1.3.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}

