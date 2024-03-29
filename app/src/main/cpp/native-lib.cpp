#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_weather_myapp_resource_Keys_apiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "BASE64_API_KEY_HERE";
    return env->NewStringUTF(api_key.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_weather_myapp_resource_Constants_getBaseUrl(JNIEnv *env, jobject thiz) {
    std::string api_key = "https://api.openweathermap.org/data/2.5/";
    return env->NewStringUTF(api_key.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_weather_myapp_resource_Constants_getImageUrl(JNIEnv *env, jobject thiz) {
    std::string api_key = "https://openweathermap.org/img/wn/";
    return env->NewStringUTF(api_key.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_weather_myapp_resource_Keys_sqlKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "bXlTcWxDaXBoZXJLZXk=";
    return env->NewStringUTF(api_key.c_str());
}