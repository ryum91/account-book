import { Category } from '@/types';

export interface RootState {
  version: string;
}

export interface CategoryState {
  categories: Array<Category>;
}
