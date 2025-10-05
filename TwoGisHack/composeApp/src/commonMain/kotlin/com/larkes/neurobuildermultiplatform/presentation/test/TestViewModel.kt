package com.larkes.neurobuildermultiplatform.presentation.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larkes.neurobuildermultiplatform.data.db.entities.TestEntity
import com.larkes.neurobuildermultiplatform.di.Inject
import com.larkes.neurobuildermultiplatform.domain.repository.TestRepository
import kotlinx.coroutines.launch
//import ru.dgis.sdk.compose.map.MapComposableState
//import ru.dgis.sdk.coordinates.Bearing
//import ru.dgis.sdk.coordinates.GeoPoint
//import ru.dgis.sdk.map.CameraPosition
//import ru.dgis.sdk.map.MapOptions
//import ru.dgis.sdk.map.Zoom
//import java.util.UUID
import kotlin.getValue


//private fun createMapOptions(): MapOptions {
//    // Position for testing controls such as Indoor и Compass.
//    val cameraPosition = CameraPosition(
//        point = GeoPoint(
//            latitude = 55.760898,
//            longitude = 37.620242
//        ),
//        bearing = Bearing(20.0),
//        zoom = Zoom(17f)
//    )
//
//    return MapOptions().apply {
//        position = cameraPosition
//    }
//}


class TestViewModel(
    private val testRepository: TestRepository
): ViewModel() {

//    val state by lazy {
//        MapComposableState(
//            mapOptions = createMapOptions()
//        )
//    }

    init {

//        viewModelScope.launch {
//            testRepository.saveData(TestEntity(
//                id = UUID.randomUUID().toString(),
//                text = "dsvsdvsvsv"
//            ))
//            Log.d("TEST_LOG", testRepository.getData().toString())
//
//        }

    }


}
