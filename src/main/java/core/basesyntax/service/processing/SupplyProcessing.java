package core.basesyntax.service.processing;

import core.basesyntax.dao.FruitsDao;

public class SupplyProcessing implements OperationProcessing {
    private FruitsDao fruitsDao;

    public SupplyProcessing(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doAction(String fruit, int amount) {
        if (amount < 0) {
            throw new RuntimeException("Amount can't be less than zero");
        }
        int oldAmount = fruitsDao.get(fruit);
        int newAmount = oldAmount + amount;
        fruitsDao.remove(fruit);
        fruitsDao.add(fruit, newAmount);
    }
}
