import { createHashRouter } from 'react-router-dom'
import { Suspense, lazy, JSX } from 'react'
import { AppLayout } from './shells/AppLayout'

// Lazy-loaded pages (named exports mapped to default)
const LandingPage = lazy(() =>
	import('@pages/landing').then(m => ({default: m.LandingPage}))
)
const SearchPage = lazy(() =>
	import('@pages/search').then(m => ({default: m.SearchPage}))
)
const DeveloperPage = lazy(() =>
	import('@pages/developer').then(m => ({default: m.DeveloperPage}))
)
const ComplexPage = lazy(() =>
	import('@pages/complex').then(m => ({default: m.ComplexPage}))
)
const ComparePage = lazy(() =>
	import('@pages/compare').then(m => ({default: m.ComparePage}))
)

const ObjectWidgetPage = lazy(() =>
	import('@pages/ObjectWidgetPage').then(m => ({default: m.default}))
)

const withSuspense = (node: JSX.Element) => (
	<Suspense fallback={ <div className="p-4">Загрузка…</div> }>{ node }</Suspense>
)

export const router = createHashRouter([
	{
		element: <AppLayout/>,
		children: [
			{path: '/', element: withSuspense(<LandingPage/>)},
			{path: '/search', element: withSuspense(<SearchPage/>)},
			{path: '/developer/:id', element: withSuspense(<DeveloperPage/>)},
			{path: '/complex/:id', element: withSuspense(<ComplexPage/>)},
			{path: '/compare', element: withSuspense(<ComparePage/>)},
			{ path: "/widget/object/:slug", element: <ObjectWidgetPage /> },
		]
	}
])
