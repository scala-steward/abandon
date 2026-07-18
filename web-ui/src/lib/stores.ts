import { writable } from 'svelte/store';

export type SelectedAmount = {
    id: string;
    amount: string;
};

export const selectedAmounts = writable<SelectedAmount[]>([]);
