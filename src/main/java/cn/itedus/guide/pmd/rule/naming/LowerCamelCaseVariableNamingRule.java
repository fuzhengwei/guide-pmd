package cn.itedus.guide.pmd.rule.naming;


import cn.itedus.guide.pmd.rule.I18nResources;
import cn.itedus.guide.pmd.rule.utils.StringAndCharConstants;
import cn.itedus.guide.pmd.rule.utils.ViolationUtils;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclarator;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.regex.Pattern;

public class LowerCamelCaseVariableNamingRule extends AbstractJavaRule {

    private static final String MESSAGE_KEY_PREFIX = "java.naming.LowerCamelCaseVariableNamingRule.violation.msg";
    private Pattern pattern = Pattern.compile("^[a-z][a-z0-9]*([A-Z][a-z0-9]+)*(DO|DTO|VO|DAO|BO|DOList|DTOList|VOList|DAOList|BOList|X|Y|Z|UDF|UDAF|[A-Z])?$");

    @Override
    public Object visit(ASTVariableDeclaratorId node, Object data) {

        if (!(pattern.matcher(node.getImage()).matches())) {
            ViolationUtils.addViolationWithPrecisePosition(this, node, data,
                    I18nResources.getMessage(MESSAGE_KEY_PREFIX + ".variable", node.getImage()));
        }

        return super.visit(node, data);
    }

    @Override
    public Object visit(ASTMethodDeclarator node, Object data) {
        if (!variableNamingStartOrEndWithDollarAndUnderLine(node.getImage())) {
            if (!(pattern.matcher(node.getImage()).matches())) {
                ViolationUtils.addViolationWithPrecisePosition(this, node, data,
                        I18nResources.getMessage(MESSAGE_KEY_PREFIX + ".method", node.getImage()));
            }
        }
        return super.visit(node, data);
    }

    private boolean variableNamingStartOrEndWithDollarAndUnderLine(String variable) {
        return variable.startsWith(StringAndCharConstants.DOLLAR)
                || variable.startsWith(StringAndCharConstants.UNDERSCORE);
    }
}
