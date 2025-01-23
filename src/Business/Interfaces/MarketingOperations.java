package Business.Interfaces;

import Business.Exceptions.ADD_EXISTED_MEMBER;
import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;
import Business.Exceptions.REMOVE_NOT_EXISTED_MEMBER;
import Business.Members.Member;

public interface MarketingOperations
{
    void addMembers(Member member) throws ADD_EXISTED_MEMBER;
    void removeMembers(Member member) throws REMOVE_NOT_EXISTED_MEMBER;
    double calculateTotalEarnings() throws CALCULATE_EARNINGS_WITHOUT_SALE;
    void showDownlines();
}