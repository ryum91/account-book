export enum Lang {
  ko,
  en
}

export enum Unit {
  PLUS,
  MINUS
}

export interface Category {
  idx: number;
  unit: Unit;
  name: string;
  parentIdx: number;
}

export interface Account {
  idx: number;
  name: string;
  color: string;
  initialBalance: string;
}

export interface History {
  idx: number;
  date: string;
  unit: Unit;
  accountIdx: number;
  categoryIdx: number;
  title: string;
  message: string;
  price: number;
}
