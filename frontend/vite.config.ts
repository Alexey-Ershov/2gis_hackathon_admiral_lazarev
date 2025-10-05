import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'
import tailwind from '@tailwindcss/vite'

export default defineConfig({
	plugins: [react(), tailwind()],
	resolve: {
		alias: {
			'@': path.resolve(__dirname, 'src'),
			'@entities': path.resolve(__dirname, 'src/entities'),
			'@features': path.resolve(__dirname, 'src/features'),
			'@widgets': path.resolve(__dirname, 'src/widgets'),
			'@pages': path.resolve(__dirname, 'src/pages'),
			'@shared': path.resolve(__dirname, 'src/shared'),
		}
	},
	server: {
		proxy: {
			'/api': {
				target: 'http://localhost:3000', // или порт, где крутится твой backend/serverless emulator
				changeOrigin: true,
			},
		},
	},
	build: {
		sourcemap: true,
	}
})
