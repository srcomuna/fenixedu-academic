package net.sourceforge.fenixedu.presentationTier.renderers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

import net.sourceforge.fenixedu.domain.Language;
import net.sourceforge.fenixedu.domain.Section;
import net.sourceforge.fenixedu.domain.Site;
import net.sourceforge.fenixedu.domain.UnitSite;
import net.sourceforge.fenixedu.domain.contents.Container;
import net.sourceforge.fenixedu.domain.contents.Content;
import net.sourceforge.fenixedu.domain.contents.MenuEntry;
import net.sourceforge.fenixedu.util.MultiLanguageString;

public abstract class UnitSiteMenuRenderer extends SiteMenuRenderer {

    // @Override
    // protected boolean isTopSection(Section section) {
    // Section target = getTargetSection(section.getSite());
    // return target == null ? super.isTopSection(section) :
        // target.hasAssociatedSections(section);
    // }
    //    
    // @Override
    // protected List<Section> getSections(Object object) {
    // Site site = getSite(object);
    //    	
    // List<Section> sections = getBaseSections(site);
    //        
    // Section section = getTargetSection(site);
    // if (section != null) {
    // sections.addAll(getTargetSubSections(section));
    // }
    //        
    // return sections;
    // }

    @Override
    protected Collection<MenuEntry> getEntries(Object object) {
	UnitSite site = (UnitSite) getSite(object);
	Container container = getTargetSection(site);
	List<MenuEntry> defaultEntries = getDefaultEntries(site); 
	if (container != null) {
	    defaultEntries.addAll(container.getMenu());
	}
	return defaultEntries;
    }

    protected List<MenuEntry> getDefaultEntries(Site site) { 
	return new ArrayList<MenuEntry>(site.getTemplate()
		.getOrderedChildrenNodes());
    }
    
    protected Section getTargetSection(Site site) {
	MultiLanguageString name = getTargetSectionName();

	for (Section section : site.getTopLevelSections()) {
	    if (equalInAnyLanguage(section.getName(), name)) {
		return section;
	    }
	}

	return null;
    }

    protected SortedSet<Section> getTargetSubSections(Section section) {
	return section.getOrderedSubSections();
    }

    protected MultiLanguageString i18n(String pt, String en) {
	MultiLanguageString mls = new MultiLanguageString();
	mls.setContent(Language.pt, pt);
	mls.setContent(Language.en, en);

	return mls;
    }

    protected abstract List<Section> getBaseSections(Site site);

    protected abstract MultiLanguageString getTargetSectionName();

    protected boolean equalInAnyLanguage(MultiLanguageString target, MultiLanguageString sub) {
	return target.equalInAnyLanguage(sub);
    }
    
    protected boolean isTemplatedContent(Site site, Content content) {
	return site.getTemplate().getChildrenAsContent().contains(content);
    }

}
