/**
 * Source: https://github.com/ACSOP/android_packages_apps_email/blob/master/src/com/android/email/MessageListContext.java
 */
public static MessageListContext forIntent(Context context, Intent intent) {
    long accountId = intent.getLongExtra(EmailActivity.EXTRA_ACCOUNT_ID, Account.NO_ACCOUNT);
    long mailboxId = intent.getLongExtra(EmailActivity.EXTRA_MAILBOX_ID, Mailbox.NO_MAILBOX);
    
    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
        final String queryTerm = intent.getStringExtra(EmailActivity.EXTRA_QUERY_STRING);
        final long searchMailboxId = Controller.getInstance(context).getSearchMailbox(accountId).mId;
        
        return forSearch(accountId, searchMailboxId, new SearchParams(mailboxId, queryTerm));
     } else {
        if (accountId == Account.NO_ACCOUNT) {
            accountId = Account.getDefaultAccountId(context);
            if (accountId == Account.NO_ACCOUNT) {
                return null;
            }
     }
     if (mailboxId == Mailbox.NO_MAILBOX) {
         mailboxId = (accountId == Account.ACCOUNT_ID_COMBINED_VIEW) ? 
                    Mailbox.QUERY_ALL_INBOXES : Mailbox.findMailboxOfType(context, accountId, Mailbox.TYPE_INBOX);
     }
     return forMailbox(accountId, mailboxId);
  }
}
