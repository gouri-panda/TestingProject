package com.example.testingproject

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var cursor: Cursor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val externalStorageState = Environment.getExternalStorageState()
        Log.d(TAG, "onCreate: externalStorageStage $externalStorageState")
        Log.d(
            TAG,
            "onCreate: externalStorageState ${externalStorageState == Environment.MEDIA_MOUNTED}"
        )
        Log.d(
            TAG,
            "onCreate: externalStorageState ${externalStorageState == Environment.MEDIA_MOUNTED_READ_ONLY}"
        )
        val dataDirectory = Environment.getDataDirectory()
        val downloadCacheDirectory = Environment.getDownloadCacheDirectory()
        val externalStorageStateNewFolder = Environment.getExternalStorageState(File("/New Folder"))
        val rootDirectory = Environment.getRootDirectory()
        val storageDirectory = Environment.getStorageDirectory()
        val externalStorageDirectory = Environment.getExternalStorageDirectory()
        val externalStoragePublicDirectoryDownload =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        Log.d(TAG, "onCreate: dataDirectory $dataDirectory")
        Log.d(TAG, "onCreate: downloadCacheDirectory $downloadCacheDirectory")
        Log.d(TAG, "onCreate: externalStorageStateNewFolder $externalStorageStateNewFolder")
        Log.d(TAG, "onCreate: rootDirectory $rootDirectory")
        Log.d(TAG, "onCreate: storageDirectory $storageDirectory")
        Log.d(TAG, "onCreate: externalStorageDirectory $externalStorageDirectory")
        Log.d(
            TAG,
            "onCreate: externalStoragePublicDirectoy $externalStoragePublicDirectoryDownload"
        )
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                //ask permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CONTACTS
                    ), 0
                )
            } else {
//                val gouriFile = File(externalStoragePublicDirectoryDownload, "gouri")
//                Log.d(TAG, "onCreate: isFileExists ${gouriFile.exists()}")
//                try {
//                    gouriFile.createNewFile()
//                } catch (e: Exception) {
//                    Log.d(TAG, "onCreate: exception ${e.message}")
//                }
//                val fooString = "hello world"
//                gouriFile.outputStream().use {
//                    it.buffered().write(fooString.toByteArray())
//                }
//                Log.d(TAG, "onCreate: isFileExists ${gouriFile.exists()}")

                /**
                 * Android data provider
                 */
//                val externalStoragePictures =
//                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//                externalStoragePictures.createNewFile()
//                externalStoragePictures.createNewFile()
//                val absolutePath = externalStorageDirectory.absolutePath
//                Log.d(TAG, "onCreate: absolutePath $absolutePath")
//                CoroutineScope(Dispatchers.IO).launch {
//                    cursor = contentResolver.query(
//                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                        null,
//                        null,
//                        null,
//                        null
//                    )
//                    var videoCount = 0
//                    while (cursor?.moveToNext() == true) {
//                        val displayName = cursor?.getString(
//                            cursor?.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME) ?: -1
//                        )
//                        videoCount++
//                        Log.d(TAG, "onCreate: displayName $displayName")
//                        val durationString = cursor?.getString(
//                            cursor?.getColumnIndex(MediaStore.Video.Media.DURATION) ?: -1
//                        )
//                        Log.d(TAG, "onCreate: durationString $durationString")
//                    }
//                    val phoneQuery = contentResolver?.query(
//                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                        null,
//                        null,
//                        null,
//                        null
//                    )
//                    phoneQuery?.use {
//                        while (phoneQuery.moveToNext()) {
//                            val displayName = phoneQuery.getString(
//                                phoneQuery.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
//                            )
//                            Log.d(TAG, "onCreate: displayName $displayName")
//                            val phoneNumber =
//                                phoneQuery.getString(phoneQuery.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//                            Log.d(TAG, "onCreate: phoneNumber $phoneNumber")
//
//                        }
//                    }
//
//                    Log.d(TAG, "onCreate: videoCount $videoCount")
//                    cursor?.close()
//                }


            }
        }


    }

}
