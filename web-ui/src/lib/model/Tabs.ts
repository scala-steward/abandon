export enum TabType {
  Balance,
  MonthlyRegister,
  Account
}

export interface TabInfo {
  tabType: TabType,
  closeable: boolean,
  getTitle(): string
}

export class BalanceTabInfo implements TabInfo {
  tabType = TabType.Balance
  closeable = false
  getTitle():string {
    return "Balance Report"
  }

}

export class MonthlyRegisterTabInfo implements TabInfo {
  tabType = TabType.MonthlyRegister
  closeable = false
  getTitle():string {
    return "Monthly Register"
  }

}

export class AccountTabInfo implements TabInfo {
  tabType = TabType.Account
  closeable = true
  name: string

  constructor(name: string) {
    this.name = name
  }

  getTitle():string {
    return this.name
  }
}