<script lang="ts">
  import AccountTab from './AccountTab.svelte';
  import BalanceTab from './BalanceTab.svelte';
  import type { Application } from "$lib/model/Application";
  import { TabType, BalanceTabInfo, type TabInfo, AccountTabInfo, MonthlyRegisterTabInfo } from '$lib/model/Tabs';
  import MonthlyRegisterView from './MonthlyRegisterView.svelte';

  export let application: Application

  let tabs: TabInfo[] = [
    new BalanceTabInfo(),
    new MonthlyRegisterTabInfo()
  ]

  let currentTabIndex = 0
  $: currentTab = tabs[currentTabIndex]

  function onFocusAccount(name: string) {
    currentTabIndex = tabs.push(new AccountTabInfo(name)) - 1
    tabs = tabs
  }

  function closeTab(index: number) {
    if (tabs[index].closeable) {
      tabs.splice(index, 1)
      currentTabIndex = Math.min(currentTabIndex, tabs.length - 1)
      tabs = tabs
    }
  }
</script>

<div>
  <ul>
    {#each tabs as tab, index}
    <li class:selected={index == currentTabIndex}>
      <div>
      <span on:click={() => currentTabIndex = index}>{tab.getTitle()}</span>
      {#if tab.closeable}
        <span class="closeButton" on:click={() => closeTab(index)}>X</span>
      {/if}
      </div>
    </li>
    {/each}
  </ul>

  <div class="contents">
    {#if currentTab.tabType == TabType.Balance}
      <BalanceTab accountBalances={application.accountBalances} {onFocusAccount} />
    {/if}
    {#if currentTab instanceof AccountTabInfo}
      <AccountTab accountName={currentTab.name} accountTxns={application.accountTxns[currentTab.name]} {onFocusAccount}/>
    {/if}
    {#if currentTab instanceof MonthlyRegisterTabInfo}
      <MonthlyRegisterView monthlySummaries={application.monthlySummaries} {onFocusAccount} />
    {/if}
  </div>

</div>

<style>
  ul {
    display: flex;
    flex-wrap: wrap;
    padding: 0;

    position:sticky;
    top: 0px;
    background-color: #0007;
    backdrop-filter: blur(.3em);
    z-index: 10;
    margin: 0;
  }
  li {
    text-decoration: none;
    list-style: none;
    padding: .33em 1em;
    background-color: #111;
    margin: .5em;
    border-radius: .1em;
    color: #aaa;
    text-transform: uppercase;
    font-family: monospace;
    font-size: 1.2em;
    border: 1px solid #333;
  }
  li:hover {
    cursor: pointer
  }
  li.selected {
    background-color: #335;
    border: 1px solid #555;
    color: #eee;
    font-weight: bold;
  }
  .closeButton {
    padding: .33em 1em;
    border:1px solid #111;
    background-color: #222;
    font-size: .8em;
    opacity: 0.7;
    font-family:sans-serif;
  }
  .contents {
    padding: 1em;
  }
</style>