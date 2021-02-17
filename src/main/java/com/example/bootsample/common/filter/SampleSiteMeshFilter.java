package com.example.bootsample.common.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class SampleSiteMeshFilter extends ConfigurableSiteMeshFilter {


    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        super.applyCustomConfiguration(builder);
        builder.addDecoratorPath("/**","/WEB-INF/decorater/layout/defaultDec.jsp")
                .addExcludedPath("/error/**");

        builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
    }
}
