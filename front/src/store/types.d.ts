import { Category, Account, History } from '@/types';

export interface RootState {
  version: string;
}

export interface CategoryState {
  categories: Array<Category>;
}

export interface AccountState {
  accounts: Array<Account>;
}

export interface HistoryState {
  histories: Array<History>;
}
