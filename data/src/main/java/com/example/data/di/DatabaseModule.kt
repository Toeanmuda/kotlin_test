import android.content.Context
import androidx.room.ProvidedTypeConverter
import androidx.room.Room
import androidx.room.TypeConverter
import com.example.data.local.InventoryDao
import com.example.data.local.InventoryRoomDatabase
import com.example.data.local.RemoteKeyDao
import com.example.entity.ArticlesItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideDatabase(@ApplicationContext context: Context): InventoryRoomDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("cpn".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(context, InventoryRoomDatabase::class.java, "item_database")
           // .openHelperFactory(factory)
            .build()
    }

    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideDao(database: InventoryRoomDatabase): InventoryDao {
        return database.inventoryDao()
    }

    @Singleton // untuk sekali instance
    @Provides  // untuk khusus inject library
    fun provideDao2(database: InventoryRoomDatabase): RemoteKeyDao {
        return database.remotekeyDao()
    }

}