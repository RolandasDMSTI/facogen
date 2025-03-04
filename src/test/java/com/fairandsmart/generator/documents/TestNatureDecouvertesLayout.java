package com.fairandsmart.generator.documents;

/*-
 * #%L
 * FacoGen / A tool for annotated GEDI based invoice generation.
 * 
 * Authors:
 * 
 * Xavier Lefevre <xavier.lefevre@fairandsmart.com> / FairAndSmart
 * Nicolas Rueff <nicolas.rueff@fairandsmart.com> / FairAndSmart
 * Alan Balbo <alan.balbo@fairandsmart.com> / FairAndSmart
 * Frederic Pierre <frederic.pierre@fairansmart.com> / FairAndSmart
 * Victor Guillaume <victor.guillaume@fairandsmart.com> / FairAndSmart
 * Jérôme Blanchard <jerome.blanchard@fairandsmart.com> / FairAndSmart
 * Aurore Hubert <aurore.hubert@fairandsmart.com> / FairAndSmart
 * Kevin Meszczynski <kevin.meszczynski@fairandsmart.com> / FairAndSmart
 * %%
 * Copyright (C) 2019 - 2020 Fair And Smart
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.fairandsmart.generator.documents.data.generator.GenerationContext;
import com.fairandsmart.generator.documents.data.model.InvoiceModel;
import com.fairandsmart.generator.documents.layout.InvoiceLayout;
import com.fairandsmart.generator.documents.layout.naturedecouvertes.NatureDecouvertesLayout;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNatureDecouvertesLayout {

    @Test
    public static void test(int nb) throws Exception {
        Path natureDecouvertes = Paths.get("target/natureDecouvertes");
        if ( !Files.exists(natureDecouvertes)) {
            Files.createDirectory(natureDecouvertes);}

        Path directoryPdf = Paths.get("target/natureDecouvertes/pdf");
        if ( !Files.exists(directoryPdf) ) {
            Files.createDirectory(directoryPdf);
        }

        Path directoryXml = Paths.get("target/natureDecouvertes/xml");
        if ( !Files.exists(directoryXml) ) {
            Files.createDirectory(directoryXml);
        }

        Path directoryTiff = Paths.get("target/natureDecouvertes/tiff");
        if ( !Files.exists(directoryTiff) ) {
            Files.createDirectory(directoryTiff);
        }

        for(int i=1; i<=nb; i++){
            Path pdf = Paths.get("target/natureDecouvertes/pdf/natureDecouvertes-"+ i + ".pdf");
            Path xml = Paths.get("target/natureDecouvertes/xml/natureDecouvertes-"+ i + ".xml");
            Path img = Paths.get("target/natureDecouvertes/tiff/natureDecouvertes-"+ i + ".tiff");

            GenerationContext ctx = GenerationContext.generate();
            InvoiceModel model = new InvoiceModel.Generator().generate(ctx);
            InvoiceLayout layout = new NatureDecouvertesLayout();
            InvoiceGenerator.getInstance().generateInvoice(layout, model, pdf, xml, img);
        }
    }

}
