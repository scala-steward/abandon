<script lang="ts">
  import type { AccountTransactions } from '$lib/model/Application';
  import TxnGroupView from './TxnGroupView.svelte';


  export let accountName: String
  export let accountTxns: AccountTransactions
  export let onFocusAccount: (name: string) => void
</script>

<h4>{accountName}</h4>
<table>
  <tbody>
  {#each accountTxns.txnsByMonth as monthlyTxns}
  <TxnGroupView name={monthlyTxns.name} group={monthlyTxns} txns={monthlyTxns.txns} {onFocusAccount}/>
  {/each}
  </tbody>
</table>

<style>
</style>

