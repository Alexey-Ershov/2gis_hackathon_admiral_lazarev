package com.larkes.neurobuildermultiplatform.presentation.builder_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larkes.neurobuildermultiplatform.data.network.source.TestNetworkDataSource
import com.larkes.neurobuildermultiplatform.domain.models.BuilderDTO
import com.larkes.neurobuildermultiplatform.domain.models.BuilderDetail
import com.larkes.neurobuildermultiplatform.domain.models.DeveloperDescription
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

fun parseResponse(jsonString: String): DeveloperDescription {
    val json = Json { ignoreUnknownKeys = true }

    // Сначала парсим верхний слой
    val wrapper = json.decodeFromString<BuilderDTO>(jsonString)

    // Потом парсим description как JSON-строку
    val inner = json.decodeFromString<DeveloperDescription>(wrapper.description)

    return inner
}
class BuilderDetailViewModel(
    private val testNetworkDataSource: TestNetworkDataSource
): ViewModel() {

    val _builderInfo: MutableStateFlow<BuilderDetail?> = MutableStateFlow<BuilderDetail?>(null)

    fun fetchBuliderInfo(id: String){
        viewModelScope.launch {
          //  val response = testNetworkDataSource.testGetRequest(id)

            //val parsed = parseResponse(response)
            _builderInfo.value = BuilderDetail(
                trustIndex = 80,
                title = "Пик",
                fromYear = 2016,
                imageSrc = "https://enjoyenglish-blog.com/wp-content/uploads/2017/07/%D0%A1%D0%BB%D0%BE%D0%B2%D0%B0-%D0%B8-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D1%81%D0%BE-%D1%81%D0%BB%D0%BE%D0%B2%D0%BE%D0%BC-%C2%AB%D0%B4%D0%BE%D0%BC%C2%BB.jpg",
                complimentPeople = listOf("Современный дизайн", "Надёжность", "Хороший сервис"),
                peopleNote = listOf("Задержка ключей", "Задержка ключей"),
                description = "Застройщик зарекомендовал себя как крупный игрок, системно предлагающий современные решения в области благоустройства дворов, организации подземных парковок и развития придомовой инфраструктуры. Это особенно ценится жителями новых районов.\n" +
                        "Наиболее частые замечания жильцов касаются двух аспектов: качества звукоизоляции в типовых планировках и неравномерной скорости решения вопросов управляющей компанией на этапе эксплуатации.\n" +
                        "Таким образом, Пик демонстрирует надежность в создании комплексной жилой среды, но ваши личные впечатления от конкретного ЖК будут сильно зависеть от проекта и года его сдачи — более новые объекты часто учитывают прошлые недочеты.\n" +
                        "Таким образом, Пик демонстрирует надежность в создании комплексной жилой среды, но ваши личные впечатления от конкретного ЖК будут сильно зависеть от проекта и года его сдачи — более новые объекты часто учитывают прошлые недочеты."
            )
        }
    }



}