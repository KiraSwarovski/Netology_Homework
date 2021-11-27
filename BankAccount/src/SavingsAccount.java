public class SavingsAccount extends Account {
    public SavingsAccount(int amount, String accountName) {
        super(amount, accountName);
    }

    @Override
    void transfer(Account account, int amount) {
        if ((getAmount() - amount) < 0) System.out.println("Not enough money");
        else {
            if (account.addMoney(amount) == true) {
                int thisTempAmount = getAmount();
                setAmount(getAmount() - amount);
                System.out.printf("%d $ marked off %s; %d $-> %d $ %n",
                        amount, getAccountName(), thisTempAmount, getAmount());
                account.addMoney(amount);
            }else {
                System.out.println("No way");
//                System.out.printf("no possibly transfer money to %s ", account.getAccountName());
            }
        }
    }

    @Override
    boolean addMoney(int amount) {
        int thisTempAmount = getAmount();
        setAmount(getAmount() + amount);
        System.out.printf("%d $ settled an %s; %d $-> %d $ %n",
                amount, getAccountName(), thisTempAmount, getAmount());
        return true;
    }
}
