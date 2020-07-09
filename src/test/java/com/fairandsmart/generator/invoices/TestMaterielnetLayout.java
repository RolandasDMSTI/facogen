package com.fairandsmart.generator.invoices;

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
 * Copyright (C) 2019 Fair And Smart
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

import com.fairandsmart.generator.invoices.data.generator.GenerationContext;
import com.fairandsmart.generator.invoices.data.model.InvoiceModel;
import com.fairandsmart.generator.invoices.layout.InvoiceLayout;
import com.fairandsmart.generator.invoices.layout.materielnet.MaterielnetLayout;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMaterielnetLayout {

    @Test
    public static void test(int nb) throws Exception {

        Path materielnet = Paths.get("target/materielnet");
        if ( !Files.exists(materielnet) ) {
            Files.createDirectory(materielnet);
        }

        for ( int i=1; i<=nb; i++) {
            Path pdf = Paths.get("target/materielnet/materielnet-" + i + ".pdf");
            Path xml = Paths.get("target/materielnet/materielnet" + i + ".xml");
            Path img = Paths.get("target/materielnet/materielnet" +i + ".tiff");

            GenerationContext ctx = GenerationContext.generate();
            ctx.setCountry("FR");
            ctx.setLanguage("fr");
            InvoiceModel model = new InvoiceModel.Generator().generate(ctx);
            InvoiceLayout layout = new MaterielnetLayout();
            InvoiceGenerator.getInstance().generateInvoice(layout, model, pdf, xml, img);
        }
    }

}
