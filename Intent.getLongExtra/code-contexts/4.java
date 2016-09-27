/**
 * Source: https://github.com/BronOS/android-hb/blob/master/src/com/bronos/hb/FiltersOrdersActivity.java
 */
private void setSelecteds(Intent intent) {
    selectedTypeId = intent.getIntExtra("type", -1);
    long accountId = intent.getLongExtra("account", 0);
    if (accountId > 0) {
        AccountsDataSource accountsDataSource = new AccountsDataSource(this);
        accountsDataSource.open();
        selectedAccount = accountsDataSource.getAccount(accountId);
        accountsDataSource.close();
     } else {
        selectedAccount = new Account();
        selectedAccount.setId(0);
        selectedAccount.setTitle("-");
        selectedAccount.setAmount(new Float(0));
     }
     long categoryId = intent.getLongExtra("category", 0);
     if (categoryId > 0) {
        CategoriesDataSource categoriesDataSource = new CategoriesDataSource(this);
        categoriesDataSource.open();
        selectedCategory = categoriesDataSource.get(categoryId);
        categoriesDataSource.close();
      } else {
        selectedCategory = new Category();
        selectedCategory.setTitle("-");
        selectedCategory.setLevel(0);
        selectedCategory.setParentId(0);
        selectedCategory.setId(0);
      }
}
