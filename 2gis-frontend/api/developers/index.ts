import type { VercelRequest, VercelResponse } from "@vercel/node";
import { ITEMS } from "./data.js";

function setCors(res: VercelResponse) {
	res.setHeader("Access-Control-Allow-Origin", "*");
	res.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS");
	res.setHeader("Access-Control-Allow-Headers", "Content-Type");
}

export default function handler(req: VercelRequest, res: VercelResponse) {
	setCors(res);

	if (req.method === "OPTIONS") {
		return res.status(204).end();
	}
	if (req.method !== "GET") {
		return res.status(405).json({ error: "Method Not Allowed" });
	}

	// Примитивная фильтрация/поиск (опционально): ?q=...
	const q = String(req.query.q ?? "").trim().toLowerCase();
	const data = q
		? ITEMS.filter(
			(it) =>
				it.title.toLowerCase().includes(q) ||
				it.developer.toLowerCase().includes(q) ||
				it.heading1.toLowerCase().includes(q)
		)
		: ITEMS;

	// Кэш на 5 минут (можно убрать/поменять)
	res.setHeader("Cache-Control", "public, max-age=300, s-maxage=300");

	return res.status(200).json(data);
}