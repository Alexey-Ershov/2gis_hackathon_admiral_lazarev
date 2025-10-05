import { useParams } from "react-router-dom";
import { useAutoHeight } from "@features/ai-summary/widget/useAutoHeight";
import WidgetLayout from "@features/ai-summary/widget/WidgetLayout";
import SummaryCard, { DeveloperItem } from "@features/ai-summary/SummaryCard";
import { DevelopersCarousel } from "@widgets/developers/Carousel";
import { useUnit } from "effector-react";
import { $popular, popularRequested } from "@entities/developer/model";
import { use, useEffect, useState } from "react";
import { DeveloperCardProps } from "@entities/developer/types";
import { api } from "@shared/api/client";
import { AISummaryResponse } from "@features/ai-summary/api";


export default function ObjectWidgetPage() {
	useAutoHeight();
	const {slug} = useParams();

	const [data, setData] = useState<DeveloperItem>()

	useEffect(() => {
		api.get(`/api/developers?q=${slug}`).json<DeveloperItem[]>().then((r)=>{console.log(r);setData(r[0])})
	}, []);

	// const data = {
	// 	"title": "West Garden",
	// 	"image": "/images/developers/example.png",
	// 	"heading1": "С 2018, 13 свободных квартир",
	// 	"listPositives": [
	// 		"Современный дизайн",
	// 		"Надёжность",
	// 		"Качественные материалы",
	// 		"Хороший сервис"
	// 	],
	// 	"markedList": [
	// 		"Повышенная стоимость"
	// 	],
	// 	"info": [
	// 		{
	// 			"heading": "Архитектура и дизайн",
	// 			"description": "Отмечается стильная и современная архитектура, высокие потолки и красивые фасады."
	// 		},
	// 		{
	// 			"heading": "Лобби",
	// 			"description": "В зонах ожидания установлена современная мебель, а почтовые ящики вызывают восторг у жителей."
	// 		},
	// 		{
	// 			"heading": "Благоустройство",
	// 			"description": "Продуманная территория с озеленённым двором-парком и набережной, где можно гулять и заниматься спортом."
	// 		},
	// 		{
	// 			"heading": "Инфраструктура",
	// 			"description": "На территории открыты гастро-бар и мини-маркет, есть свой детский сад."
	// 		},
	// 		{
	// 			"heading": "Расположение",
	// 			"description": "Близость к лесу и реке, а также удобный выезд на скоростные трассы, позволяющий быстро добраться до центра Москвы."
	// 		},
	// 		{
	// 			"heading": "Качество строительства",
	// 			"description": "После сдачи первых очередей, жильцы отмечают высокое качество отделки квартир и готовность к заселению."
	// 		}
	// 	],
	// 	"developer": "Sminex",
	// 	"otherProjects": [
	// 		{
	// 			"title": "Foriver",
	// 			"rating": 5.0,
	// 			"tags": ["Своя набережная", "Возле метро"],
	// 			"image": "https://example.com/foriver.jpg"
	// 		},
	// 		{
	// 			"title": "Life Time",
	// 			"rating": 5.0,
	// 			"tags": ["Террасы", "Инфраструктура"],
	// 			"image": "https://example.com/lifetime.jpg"
	// 		}
	// 	]
	// }

	useEffect(() => {
		console.log("updated")
	}, [data]);


	return (
		<WidgetLayout>
			<SummaryCard data={data} />
		</WidgetLayout>
	);
}