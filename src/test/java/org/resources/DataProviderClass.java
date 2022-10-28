package org.resources;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "emails")
    public Object[][] getEmailsFromProvider() {
        return new Object[][] {
                {"testmail.com"},
                {"test@mailcom"},
                {"thisistoolongtestmailthatshouldnotbeaxeptedfromthesystemtheproblemaboutthisisthat255symbolsaretoolongforstandardizedemailprovideranditlooksverryunlikelysomeonetousethattypeofemailneedmoresymbolsiamoutofideasaboutthat10morejustaltlle@unusualemailprovider.com"}
        };
    }

    @DataProvider(name = "passwords")
    public Object[][] getPasswordsFromProvider() {
        return new Object[][]{
                {"P@ssword"},
                {"1p@ssword"},
                {"1Password"},
                {"1P@SSWORD"},
                {"1p@ssword"},
                {"1P@ss"},
                {"1p@sswordforusage"},
        };
    }
}

