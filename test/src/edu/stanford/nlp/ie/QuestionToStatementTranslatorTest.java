package edu.stanford.nlp.naturalli;

import edu.stanford.nlp.ie.util.IETestUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * A bunch of tests of the question to statement translator, taken from the
 * webquestions training set (http://www-nlp.stanford.edu/software/sempre/).
 *
 * @author Gabor Angeli
 */
public class QuestionToStatementTranslatorTest {

  private final QuestionToStatementTranslator instance;

  public QuestionToStatementTranslatorTest() {
    instance = new QuestionToStatementTranslator();
  }

  @Test
  public void canInitialize() { }

  private void check(String input, String output) {
    List<List<CoreLabel>> results = instance.toStatement(IETestUtils.parseSentence(input));
    assertTrue(results.size() > 0);
    assertEquals(output,
        StringUtils.join(results.get(0).stream().map(CoreLabel::word), " "));
  }

  @Test
  public void parseWhatIs() {
    check(
        "what/WP is/VBZ nina/NNP dobrev/NNP nationality/NN ?",
        "nina dobrev nationality is thing");
    check(
        "what/WP is/VBZ the/DT president/NN of/PRP brazil/NNP ?",
        "the president of brazil is thing");
    check(
        "what/WP is/VBZ saint/NNP nicholas/NNP known/VBN for/PRP ?",
        "saint nicholas is known for thing");
    check(
        "what/WP is/VBZ cher/NNP 's/POS son/NN 's/POS name/NN ?",
        "cher 's son 's name is thing");
    check(
        "what/WP is/VBZ martin/NNP cooper/NNP doing/VBG now/RB ?",
        "martin cooper is now doing thing");
    check(
        "what/WP is/VBZ medicare/NN a/NN ?",
        "medicare a is thing");
    check(
        "what/WP is/VBZ the/DT name/NN of/PRP the first harry potter novel ?",
        "the first harry potter novel is thing");
    check(
        "what/WP is/VBZ the/DT first book sherlock holmes appeared in ?",
        "the first book sherlock holmes appeared in is thing");
    check(
        "what/WP is/VBZ charles/NN darwin/NN famous/JJ for/IN ?",
        "charles darwin is famous for thing");
    check(
        "what/WP is/VBZ henry/NNP clay/NNP known/VBN for/IN ?",
        "henry clay is known for thing");
    check(
        "what/WP is/VBZ the/DT money/NN in/IN spain/NNP called/VBN ?",
        "the money in spain is called thing");
    check(
        "what/WP is/VBZ the/DT name/NN of/PRP the pittsburgh steelers head coach ?",
        "the pittsburgh steelers head coach is thing");
    check(
        "what/WP is/VBZ james/NNP madison/NNP most/RBS famous/JJ for/IN ?",
        "james madison is most famous for thing");
    check(
        "what/WP is/VBZ the/DT china/NNP money/NN called/VBN ?",
        "the china money is called thing");
    check(
        "what/WP is/VBZ john/NNP steinbeck/NNP best/RB known/VBN for/IN ?",
        "john steinbeck is best known for thing");
    check(
        "what/WP is/VBZ st/NNP francis/NNP the/DT patron/JJ saint/NN of/IN ?",
        "st francis is the patron saint of thing");
    check(
        "what/WP is/VBZ daniel/NNP radcliffe/NNP name/NN in/IN the/DT woman/NN in/IN black/NN ?",
        "daniel radcliffe name in the woman in black is thing");
    check(
        "what/WP island/NN is/VBZ bethany/NNP hamilton/NNP from/IN ?",
        "bethany hamilton is from island");
    check(
        "what/WP is/VBZ the/DT senate/NN responsible/JJ for/IN ?",
        "the senate is responsible for thing");
    check(
        "what/WP is/VBZ the/DT name/NN of/PRP justin/NNP bieber/NNP brother/NN ?",
        "justin bieber brother is thing");
    check(
        "what/WP is/VBZ the/DT dollar/NN called/VBD in/IN spain/NNP ?",
        "the dollar is called thing in spain");
  }

  @Test
  public void parseWhatAre() {
    check(
        "what/WP are/VBZ the/DT major/NN cities/NN in/IN france/NNP ?",
        "the major cities in france are thing");
    check(
        "what/WP are/VBZ dollars/NN called/VBD in/IN spain/NNP ?",
        "dollars are called thing in spain");
    check(
        "what/WP are/VBZ the/DT main/JJ languages/NNS of/IN nigeria/NNP ?",
        "the main languages of nigeria are thing");
    check(
        "what/WP are/VBZ the/DT major/JJ religions/NNS of/IN russia/NNP ?",
        "the major religions of russia are thing");
    check(
        "what/WP are/VBZ fun/NN things/NNS to/IN do/DO in/IN seattle/NNP washington/NNP ?",
        "fun things to do in seattle washington are thing");
    check(
        "what/WP are/VBZ the/DT holydays/NNS of/IN obligation/NN in/IN the/DT catholic/NNP church/NNP 2013/CD ?",
        "the holydays of obligation in the catholic church in 2013 are thing");
  }

  @Test
  public void parseWhatWas() {
    check(
        "what/WP was/VBD malcolm/NNP x/NNP trying/VBG to/TO accomplish/VB ?",
        "malcolm x was trying to accomplish thing");
    check(
        "what/WP was/VBD the/DT name/NN of/IN frederick/NNP douglas/NNP book/NN ?",
        "the name of frederick douglas book was thing");
    check(
        "what/WP was/VBD marilyn/NNP monroe/NNP known/VBD for/IN ?",
        "marilyn monroe was known for thing");
    check(
        "what/WP was/VBD lincoln/NNP 's/POS wife/NN 's/POS name/NN ?",
        "lincoln 's wife 's name was thing");
  }

  @Test
  public void parseWhatIsThere() {
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN laredo/NNP tx/NNP ?",
        "there is thing to do in laredo tx");
    check(
        "what/WP is/VBZ there/RB to/TO see/VB in/IN barcelona/NNP ?",
        "there is thing to see in barcelona");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN gatlinburg/NNP in/IN december/NNP ?",
        "there is thing to do in gatlinburg in december");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN mt/NNP baldy/NNP california/NNP ?",
        "there is thing to do in mt baldy california");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB around/IN austin/NNP texas/NNP ?",
        "there is thing to do around austin texas");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN niagara/NNP falls/NNP new/NNP york/NNP ?",
        "there is thing to do in niagara falls new york");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN palm/NNP springs/NNP ?",
        "there is thing to do in palm springs");
    check(
        "what/WP is/VBZ there/RB to/TO see/VB near/IN the/DT grand/NNP canyon/NNP ?",
        "there is thing to see near the grand canyon");
    check(
        "what/WP is/VBZ there/RB for/IN kids/NN to/TO do/VB in/IN miami/NNP ?",
        "there is thing for kids to do in miami");
    check(
        "what/WP is/VBZ there/RB fun/NN to/TO do/VB in/IN san/NNP diego/NNP ?",
        "there is fun thing to do in san diego");
    check(
        "what/WP is/VBZ there/RB to/TO do/VB in/IN montpelier/NNP vt/NNP ?",
        "there is thing to do in montpelier vt");
  }

  @Test
  public void parseWhatNounIs() {
    check(
        "what/WP language/NN is/VBZ spoken/VBD in/IN singapore/NNP ?",
        "language is spoken in singapore");
    check(
        "what/WP airport/NN is/VBZ closest/JJS to/IN houston/NNP ?",
        "airport is closest to houston");
    check(
        "what/WP airport/NN is/VBZ closer/RBS to/IN houston/NNP ?",
        "airport is closer to houston");
    check(
        "what/WP branch/NN is/VBZ made/VB up/IN of/IN the/DT house/NNP of/NNP representatives/NNP ?",
        "branch is made up of the house of representatives");
  }

  @Test
  public void parseWhatNounHas() {
    check(
        "what/WP awards/NNS has/VBZ louis/NNP sacher/NNP won/VB ?",
        "louis sacher has won awards");
    check(
        "what/WP movies/NNS has/VBZ taylor/NNP lautner/NNP been/VBD in/IN 2011/CD ?",
        "taylor lautner has been in movies in 2011");
    check(
        "what/WP clubs/NNS has/VBZ peter/NNP crouch/NNP played/VBD for/IN ?",
        "peter crouch has played for clubs");
    check(
        "what/WP movies/NNS has/VBZ michael/NNP clarke/NNP duncan/NNP been/VBD in/IN ?",
        "michael clarke duncan has been in movies");
  }

  @Test
  public void parseWhatNounHasNP() {
    check(
        "what/WP countries/NNS has/VBZ spanish/NNP as/IN their/PRP$ official/JJ language/NN ?",
        "countries has spanish as their official language");
  }

  @Test
  public void parseWhatDoVP() {
    check(
        "what/WP kind/JJ of/IN economy/NN does/VB china/NNP have/VBZ ?",
        "china have kind of economy");
    check(
        "what/WP character/NN did/VBD natalie/NNP portman/NNP play/VB in/IN star/NNP wars/NNP ?",
        "natalie portman play character in star wars");
    check(
        "what/WP country/NN is/VBD the/DT grand/NNP bahama/NNP island/NNP in/IN ?",
        "the grand bahama island is in country");
    check(
        "what/WP was/VBD tupac/NNP name/NN in/IN juice/NNP ?",
        "tupac name in juice was thing");
    check(
        "what/WP planes/NNP does/VBZ the/DT navy/NNP have/VBZ ?",
        "the navy have planes");
  }

  @Test
  public void parseWhatHas() {
    check(
        "what/WP has/VBZ barack/NNP obama/NNP done/VB wrong/JJ ?",
        "barack obama has done thing wrong");
    check(
        "what/WP has/VBZ anna/NNP kendrick/NNP been/VBN in/IN ?",
        "anna kendrick has been in thing");
    check(
        "what/WP has/VBZ been/VBN discovered/VBD on/IN mars/NNP so/RB far/RB ?",
        "thing has been discovered on mars so far");
  }

  @Test
  public void parseWhereDid() {
    check(
        "where/WRB did/VBD saki/NNP live/VB ?",
        "saki live at location");
    check(
        "where/WRB did/VBD dmitri/NNP mendeleev/NNP study/VB science/NN ?",
        "dmitri mendeleev study science at location");
    check(
        "where/WRB did/VBD boston/NNP terriers/NNP come/VBP from/IN ?",
        "boston terriers come from location");
    check(
        "where/WRB did/VBD madoff/NNP live/VP in/IN nyc/NNP ?",
        "madoff live in location , nyc");
    check(
        "where/WRB did/VBD kaiser/NNP wilhelm/NNP fled/VBD to/IN ?",
        "kaiser wilhelm fled to location");
  }

  @Test
  public void parseWhereDoes() {
    check(
        "where/WRB does/VB lani/NNP river/NNP begin/VB and/CC end/VB ?",
        "lani river begin and end at location");
    check(
        "where/WRB does/VB asiana/NNP airlines/NNP fly/VB to/TO ?",
        "asiana airlines fly to location");
    check(
        "where/WRB does/VB the/DT un/NNP get/VB its/PRP$ funding/NN ?",
        "the un get its funding from thing");
    check(
        "where/WRB does/VB the/DT name/NN melbourne/NNP come/VB from/IN ?",
        "the name melbourne come from thing");
  }

  @Test
  public void parseWhereIs() {
    check(
        "where/WRB is/VBD jack/NNP daniels/NNP factory/NN ?",
        "jack daniels factory is at location");
    check(
        "where/WRB is/VBD rome/NNP italy/VB located/VBD on/IN a/DT map/NN ?",
        "rome italy is at location");
    check(
        "where/WRB is/VBD jefferson/NNP davis/VB buried/VBD ?",
        "jefferson davis is buried at location");
    check(
        "where/WRB is/VBD american/NNP express/NNP located/JJ ?",
        "american express is located at location");
    check(
        "where/WRB is/VBD tom/NNP cruise/NNP from/IN ?",
        "tom cruise is from location");
    check(
        "where/WRB is/VBD atlanta/NNP texas/NNP located/VBN ?",
        "atlanta texas is located at location");
    check(
        "where/WRB is/VBD belgium/NNP at/IN ?",
        "belgium is at location");
    check(
        "where/WRB is/VBD made/VB kia/NNP car/NN ?",
        "kia car is made at location");
    check(
        "where/WRB is/VBD greyhound/NNP station/NNP in/IN washington/NNP dc/NNP ?",
        "greyhound station in washington dc is at location");
  }

  @Test
  public void parseWhoIs() {
    check(
        "who/WRB is/VBD the/DT prime/NNP minister/NNP of/IN ethiopia/NNP ?",
        "the prime minister of ethiopia is person");
    check(
        "who/WRB is/VBD sanjay/NNP gupta/NNP married/VBD to/IN ?",
        "sanjay gupta is married to person");
    check(
        "who/WRB is/VBD sanjay/NNP gupta/NNP married/VBD too/RB ?",
        "sanjay gupta is married to person");
    check(
        "who/WRB is/VBD the/DT prime/NN minister/NN of/IN new/NNP zealand/NNP now/RB ?",
        "the prime minister of new zealand is person now");
    check(
        "who/WRB is/VBD jennifer/NNP lawrence/NNP boyfriend/NN 2012/CD ?",
        "jennifer lawrence boyfriend in 2012 is person");
    check(
        "who/WRB is/VBD neil/NNP patrick/NNP harris/NNP dating/VBG ?",
        "neil patrick harris is dating person");
    check(
        "who/WRB is/VBD timothy/NNP hutton/NNP married/VBD to/TO ?",
        "timothy hutton is married to person");
  }

  @Test
  public void parseWhoIsIn() {
    check(
        "who/WRB is/VBD in/IN the/DT band/NN bush/NNP ?",
        "person is in the band bush");
  }

  @Test
  public void parseWhoWas() {
    check(
        "who/WRB was/VBD ishmael/NNP 's/POS mom/NN ?",
        "ishmael 's mom was person");
    check(
        "who/WRB was/VBD neptune/NNP discovered/VBD by/IN ?",
        "neptune was discovered by person");
    check(
        "who/WRB was/VBD the/DT president/NN after/IN jfk/NNP died/VBD ?",
        "the president after jfk died was person");
    check(
        "who/WRB was/VBD the/DT apostle/NN paul/NNP considered/VBD to/TO be/VB ?",
        "the apostle paul was considered to be person");
    check(
        "who/WRB was/VBD the/DT first/JJ russian/NNP president/NN ?",
        "the first russian president was person");
    check(
        "who/WRB was/VBD judy/NNP garland/NNP married/VBD to/TO ?",
        "judy garland was married to person");
    check(
        "who/WRB was/VBD josh/NNP groban/NNP in/IN crazy/NNP stupid/NNP love/NNP ?",
        "josh groban in crazy stupid love was person");  // somewhat sub-optimal, but parse tree is ok
    check(
        "who/WRB was/VBD married/VBD to/TO lance/NNP armstrong/NNP ?",
        "person was married to lance armstrong");
    check(
        "who/WRB was/VBD judy/NNP collins/NNP married/VBD to/TO ?",
        "judy collins was married to person");
    check(
        "who/WRB was/VBD niccolo/NNP machiavelli/NNP influenced/VBD by/IN ?",
        "niccolo machiavelli was influenced by person");
    check(
        "who/WRB was/VBD betty/NNP white/NNP married/VBD too/RB ?",
        "betty white was married to person");
  }

  @Test
  public void parseWhoDid() {
    check(
        "who/WRB did/VBD draco/NNP malloy/NNP end/NN up/RP marrying/VBG ?",
        "draco malloy end up marrying person");
    check(
        "who/WRB did/VBD ben/NNP stiller/NNP play/VB in/IN megamind/NNP ?",
        "ben stiller play person in megamind");
    check(
        "who/WRB did/VBD elton/NNP john/NNP marry/VB first/RB ?",
        "elton john marry person first");
    check(
        "who/WRB did/VBD the/DT voice/NN of/IN darth/NNP vader/NNP in/IN star/NNP wars/NNP ?",
        "person did the voice of darth vader in star wars");
    check(
        "who/WRB did/VBD anne/NNP frank/NNP wrote/VBD her/PRP$ diary/NN to/TO ?",
        "anne frank wrote her diary to person");
    check(
        "who/WRB did/VBD japan/NNP surrender/VB to/TO in/IN ww2/NNP ?",
        "japan surrender to person in ww2");
    check(
        "who/WRB did/VBD warren/NNP moon/VB play/VB for/IN ?",
        "warren moon play for person");
    check(
        "who/WRB did/VBD cristina/NNP yang/NNP 's/POS husband/NN cheated/VBD on/IN her/PRP$ with/IN ?",
        "cristina yang 's husband cheated on her with person");
    check(
        "who/WRB did/VBD butler/NNP beat/VB last/JJ night/NN ?",
        "butler beat person last night");
    check(
        "who/WRB did/VBD the/DT voice/NN of/IN kitt/NNP in/IN night/NNP rider/NNP ?",
        "person did the voice of kitt in night rider");
  }

  @Test
  public void parseWhatDid() {
    check(
        "what/WRB did/VBD the/DT german/NNP revolution/NNP lead/NN to/TO ?",
        "the german revolution lead to thing");
    check(
        "what/WRB did/VBD william/NNP shakespeare/NNP do/VB for/IN a/DT living/NN ?",
        "william shakespeare did thing for a living");
    check(
        "what/WRB did/VBD shawnee/NNP smith/NNP play/VB in/IN ?",
        "shawnee smith play in thing");
    check(
        "what/WRB did/VBD nick/NNP clegg/NNP study/VB at/IN university/NN ?",
        "nick clegg study thing at university");
    check(
        "what/WRB did/VBD rob kardashian get surgery for ?",
        "rob kardashian get surgery for thing");
    check(
        "what/WRB did/VBD st./NNP matthew/NNP do/IN ?",
        "st. matthew did thing");
    check(
        "what/WRB did/VBD gregor/NNP mendel/NNP conducted/VBD his/PRP$ experiments/NN on/IN ?",
        "gregor mendel conducted his experiments on thing");
    check(
        "what/WRB did/VBD patrick/NNP swayze/NNP sing/VB ?",
        "patrick swayze sing thing");
    check(
        "what/WRB did/VBD abraham/NNP lincoln/NNP do/IN before/IN he/PRP was/VBD president/NN ?",
        "abraham lincoln did thing before he was president");
    check(
        "what/WRB did/VBD obama/NNP study/VB in/IN school/NN ?",
        "obama study thing in school");
    check(
        "what/WRB did/VBD hans/NNP oersted/NNP discovered/VBD in/IN 1819/CD ?",
        "hans oersted discovered thing in 1819");
    check(
        "what/WRB did/VBD mozart/NNP do/VB to/IN become/IN famous/NN ?",
        "mozart did thing to become famous");
    check(
        "what/WRB did/VBD taylor/NNP swift/NNP do/VB at/IN the/DT vmas/NNP 2012/CD ?",
        "taylor swift did thing at the vmas in 2012");
    check(
        "what/WRB did/VBD kenny/NNP everett/NNP die/VB off/RP ?",
        "kenny everett die of thing");
    check(
        "what/WRB did/VBD isaac/NNP newton/NNP discover/VB as/IN a/DT mathematician/NN ?",
        "isaac newton discover thing as a mathematician");
  }

  @Test
  public void parseWhenDid() {
    check(
        "when/WRB did/VBD the/DT colorado/NNP rockies/NNP go/VB to/TO the/DT world/NNP series/NNP ?",
        "the colorado rockies go to the world series in time");
    check(
        "when/WRB did/VBD the/DT new/NNP york/NNP knicks/NNP win/VB the/DT championship/NN ?",
        "the new york knicks win the championship in time");
    check(
        "when/WRB did/VBD sherlock/NNP holmes/NNP live/VB in/IN ?",
        "sherlock holmes live in time");
  }

}
