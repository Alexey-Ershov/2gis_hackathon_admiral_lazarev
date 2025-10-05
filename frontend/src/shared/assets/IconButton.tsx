import type { ReactNode } from 'react';
import { clsx } from 'clsx';

type Props = {
	className?: string;
	onClick?: () => void;
	children: ReactNode;
};

export function IconButton({className, children, ...rest}: Props) {
	return (
		<div
			className={ clsx(
				'w-fit h-fit text-white transition cursor-pointer',
				className
			) }
			{ ...rest }
		>
			{ children }
		</div>
	);
}

