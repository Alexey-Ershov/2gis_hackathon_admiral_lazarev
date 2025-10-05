import { Card, CardCover, CardFavButton, CardMetaRow, CardRating, CardTitle } from "@shared/ui/card";
import { JSX } from "react";
import { DeveloperCardProps } from "@entities/developer/types";


export function DeveloperCard(props: DeveloperCardProps): JSX.Element {
	return (
		<Card className={"gap-[6px] flex-1 primary-font"}>
			<CardCover
				src={ props.image }
				alt="Картинка"
			>
				{ props.rating ? <CardRating value={ props.rating }/> : <></> }
				<CardFavButton/>
				{/* если нужен тег на обложке */ }
				{/* <CardTag label="от Setl Group" /> */ }
			</CardCover>

			<CardTitle>{ props.title }</CardTitle>
			<CardMetaRow left={ props.metaLeft } right={ props.metaRight } separator="gap"/>
		</Card>
	)
}